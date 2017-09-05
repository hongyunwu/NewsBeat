package com.why.newsbeat.base.guonei.api;

import com.why.newsbeat.base.guonei.bean.GuoNeiBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface GuoNeiService {

	@GET("toutiao/index")
	Observable<GuoNeiBean> getGuoNeiNews(@Query("type") String type, @Query("key") String key);

}
