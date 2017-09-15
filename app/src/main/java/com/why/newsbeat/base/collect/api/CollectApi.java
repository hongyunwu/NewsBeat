package com.why.newsbeat.base.collect.api;

/**
 * Created by lenovo on 2017/9/15.
 */

public interface CollectApi {

	/**
	 * 加载收藏列表
	 * @param number 加载的数量
	 * @param page 加载页码
	 */
	void loadCollections(int number,int page);
}
