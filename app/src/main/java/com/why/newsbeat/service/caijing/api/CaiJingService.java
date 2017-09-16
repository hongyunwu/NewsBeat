package com.why.newsbeat.service.caijing.api;

import com.why.newsbeat.service.caijing.bean.CaiJingBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface CaiJingService {

	@GET("toutiao/index")
	Observable<CaiJingBean> getCaiJingNews(@Query("type") String type, @Query("key") String key);

}
