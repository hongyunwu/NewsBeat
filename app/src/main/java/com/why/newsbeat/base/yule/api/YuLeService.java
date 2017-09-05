package com.why.newsbeat.base.yule.api;

import com.why.newsbeat.base.yule.bean.YuLeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface YuLeService {

	@GET("toutiao/index")
	Observable<YuLeBean> getYuLeNews(@Query("type") String type, @Query("key") String key);

}
