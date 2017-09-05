package com.why.newsbeat.base.keji.api;

import com.why.newsbeat.base.keji.bean.KeJiBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface KeJiService {

	@GET("toutiao/index")
	Observable<KeJiBean> getkeJiNews(@Query("type") String type, @Query("key") String key);

}
