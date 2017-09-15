package com.why.newsbeat.base.history.api;

import com.why.base.cache.AppCache;
import com.why.base.executor.ThreadManager;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.history.bean.History;
import com.why.newsbeat.base.history.event.HistoryNewsEvent;
import com.why.newsbeat.dao.greendao.HistoryDao;
import com.why.newsbeat.dao.manager.DBManager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */

public class HistoryImpl implements HistoryApi {

	@Override
	public void loadHistories(final int number, final int page) {

		ThreadManager
				.getInstance()
				.getDefaultPool()
				.excute(new Runnable() {
					@Override
					public void run() {

						//数据库查询
						List<History> historyList = DBManager
								.getDaoSession(AppCache.getContext())
								.getHistoryDao()
								.queryBuilder()
								.where(HistoryDao.Properties.Username.eq(NewsBeat.getUserName()))
								.orderDesc(HistoryDao.Properties.Save_time)
								.limit(number)
								.offset(page * number)
								.build()
								.list();

						EventBus.getDefault().post(new HistoryNewsEvent(historyList));


					}
				});

	}
}
