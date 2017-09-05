package com.why.newsbeat.base.guoji.api;

import com.why.newsbeat.base.guoji.bean.GuoJiBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface GuoJiService {

	@GET("toutiao/index")
	Observable<GuoJiBean> getGuoJiNews(@Query("type") String type, @Query("key") String key);

}
