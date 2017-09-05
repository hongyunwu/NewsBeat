package com.why.newsbeat.base.tiyu.api;

import com.why.newsbeat.base.tiyu.bean.TiYuBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface TiYuService {

	@GET("toutiao/index")
	Observable<TiYuBean> getTiYuNews(@Query("type") String type, @Query("key") String key);

}
