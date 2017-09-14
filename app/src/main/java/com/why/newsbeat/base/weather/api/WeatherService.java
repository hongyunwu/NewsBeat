package com.why.newsbeat.base.weather.api;

import com.why.newsbeat.base.top.bean.TopBean;
import com.why.newsbeat.base.weather.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/9/14.
 */

public interface WeatherService {

	//http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY
	@GET("weather/index")
	Observable<WeatherBean> getWeather(@Query("cityname") String cityname, @Query("key") String key);
}
