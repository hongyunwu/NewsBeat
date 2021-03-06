package com.why.newsbeat.service.shehui.api;

import com.why.newsbeat.service.shehui.bean.SheHuiBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/2.
 */

public interface SheHuiService {

	@GET("toutiao/index")
	Observable<SheHuiBean> getSheHuiNews(@Query("type") String type, @Query("key") String key);

}
