package com.why.newsbeat.service.weather.api;

/**
 * Created by lenovo on 2017/9/14.
 */

public interface WeatherApi {

	/**
	 * 加载天气数据
	 *
	 * @param cityName 当前城市
	 */
	void loadWeather(String cityName);
}
