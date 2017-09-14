package com.why.newsbeat.base.weather.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.top.bean.TopBean;
import com.why.newsbeat.base.weather.bean.WeatherBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class WeatherEvent extends BaseEvent<WeatherBean> {

	public WeatherEvent(WeatherBean mEvent) {
		super(mEvent);
	}
}
