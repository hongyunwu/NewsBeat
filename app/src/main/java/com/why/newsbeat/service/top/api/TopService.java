package com.why.newsbeat.service.top.api;

import com.why.newsbeat.service.top.bean.TopBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface TopService {

	@GET("toutiao/index")
	Observable<TopBean> getTopNews(@Query("type") String type,@Query("key") String key);

}
