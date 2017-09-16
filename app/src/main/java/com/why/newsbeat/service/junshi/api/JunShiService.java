package com.why.newsbeat.service.junshi.api;

import com.why.newsbeat.service.junshi.bean.JunShiBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface JunShiService {

	@GET("toutiao/index")
	Observable<JunShiBean> getJunShiNews(@Query("type") String type, @Query("key") String key);

}
