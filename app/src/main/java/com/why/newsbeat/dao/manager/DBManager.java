package com.why.newsbeat.dao.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.service.collect.bean.Collect;
import com.why.newsbeat.service.history.bean.History;
import com.why.newsbeat.dao.greendao.CollectDao;
import com.why.newsbeat.dao.greendao.DaoMaster;
import com.why.newsbeat.dao.greendao.DaoSession;
import com.why.newsbeat.dao.greendao.HistoryDao;

import java.util.List;

/**
 * Created by wuhongyun on 17-7-20.
 *
 * 数据库管理类
 */

public class DBManager {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DBManager(){

    }
    private static DBManager dataBaseManager = null;

    /**
     * 单例
     * @return 返回构造好的数据库管理单例
     */
    private static DBManager getInstance(){
        if (dataBaseManager==null){
            synchronized (DBManager.class){
                if (dataBaseManager==null){
                    dataBaseManager = new DBManager();
                }
            }
        }
        return dataBaseManager;
    }

    /**
     * 初始化操作，一般可以将此放在application的oncreate中
     * @param context
     */
    public static void init(Context context){

        getInstance().newDaoMaster(context);
    }

    /**
     * 获取音乐数据表的session
     * @param context
     */
    private void newDaoMaster(Context context) {
        mHelper = new DaoMaster.DevOpenHelper(context, "news-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    /**
     * 获取DaoSession
     *
     * @param context 如果之前没有进行init操作，就会用到
     * @return DaoSession 可使用此获取DAO实例
     */
    public static DaoSession getDaoSession(Context context){

        DaoSession mDaoSession = getInstance().mDaoSession;
        if (mDaoSession==null){
            getInstance().newDaoMaster(context);
        }
        return mDaoSession;
    }

	/**
	 * 插入收藏，多用户/
     *
     * @param context
     * @param collect
     */
    public static void insert(Context context,Collect collect){

        CollectDao collectDao = getDaoSession(context)
                .getCollectDao();
        if (collectDao
                .queryBuilder()
                .where(CollectDao.Properties.Uniquekey.eq(collect.getUniquekey())
                        , CollectDao.Properties.Username.eq(collect.getUsername()))
                .build()//先确定数据库 当前用户是否有当前收藏
                .list()
                .size()==0){
            collectDao
                    .insert(collect);
        }
    }

    public static List<Collect> queryCollect(Context context, String uniquekey, String userName) {
        LogUtils.i("queryCollect->uniquekey:"+uniquekey+",username:"+userName);
        return getDaoSession(context)
                .getCollectDao()
                .queryBuilder()
                .where(CollectDao.Properties.Uniquekey.eq(uniquekey), CollectDao.Properties.Username.eq(userName))
                .build()
                .list();


    }


	/**
	 * 删除收藏
     *
     * @param context
     * @param collect
     */
    public static void delete(Context context, Collect collect) {
        CollectDao collectDao = getDaoSession(context)
                .getCollectDao();

        List<Collect> list = collectDao
                .queryBuilder()
                .where(CollectDao.Properties.Uniquekey.eq(collect.getUniquekey())
                        , CollectDao.Properties.Username.eq(collect.getUsername()))
                .build()//先确定数据库 当前用户是否有当前收藏
                .list();
        if (list.size()>0){
            Collect deleteBean = list.get(0);
            LogUtils.i("delete:"+deleteBean.getTitle()+",size:"+list.size());
            collectDao.delete(deleteBean);
        }
    }

    /**
     * 插入历史，多用户/
     *
     * @param context
     * @param history
     */
    public static void insert(Context context,History history){

        HistoryDao historyDao = getDaoSession(context)
                .getHistoryDao();
        List<History> historyList = historyDao
                .queryBuilder()
                .where(HistoryDao.Properties.Uniquekey.eq(history.getUniquekey())
                        , HistoryDao.Properties.Username.eq(history.getUsername()))
                .build()//先确定数据库 当前用户是否有当前收藏
                .list();
        if (historyList
                .size()==0){
            historyDao
                    .insert(history);
        }else{
            historyDao.delete(historyList.get(0));
            historyDao.insert(history);
        }
    }

    /**
     * 删除足迹
     *
     * @param context
     * @param history
     */
    public static void delete(Context context, History history) {
        HistoryDao historyDao = getDaoSession(context)
                .getHistoryDao();

        List<History> list = historyDao
                .queryBuilder()
                .where(HistoryDao.Properties.Uniquekey.eq(history.getUniquekey())
                        , HistoryDao.Properties.Username.eq(history.getUsername()))
                .build()//先确定数据库 当前用户是否有当前收藏
                .list();
        if (list.size()>0){
            History deleteBean = list.get(0);
            LogUtils.i("delete:"+deleteBean.getTitle()+",size:"+list.size());
            historyDao.delete(deleteBean);
        }
    }

}
