package com.why.newsbeat.service.collect.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.why.newsbeat.service.collect.bean.Collect;
import com.why.newsbeat.service.collect.dao.CollectDao;
import com.why.newsbeat.service.collect.dao.DaoMaster;
import com.why.newsbeat.service.collect.dao.DaoSession;

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
	 * 插入收藏
     *
     * @param context
     * @param collect
     */
    public static void insert(Context context,Collect collect){

        CollectDao collectDao = getDaoSession(context)
                .getCollectDao();
        if (collectDao
                .queryBuilder()
                .where(CollectDao.Properties.Uniquekey.eq(collect.getUniquekey()))
                .build()
                .list()
                .size()==0){
            collectDao
                    .insert(collect);
        }


    }

}
