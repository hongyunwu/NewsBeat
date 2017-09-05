package com.why.newsbeat.base.shishang.api;

import com.why.newsbeat.base.shishang.bean.ShiShangBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface ShiShangService {

	@GET("toutiao/index")
	Observable<ShiShangBean> getShiShangNews(@Query("type") String type, @Query("key") String key);

}
