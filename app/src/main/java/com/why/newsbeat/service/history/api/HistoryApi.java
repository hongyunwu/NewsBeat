package com.why.newsbeat.service.history.api;

/**
 * Created by lenovo on 2017/9/15.
 */

public interface HistoryApi {

	/**
	 * 加载收藏列表
	 * @param number 加载的数量
	 * @param page 加载页码
	 */
	void loadHistories(int number, int page);
}
