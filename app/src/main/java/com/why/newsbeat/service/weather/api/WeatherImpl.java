package com.why.newsbeat.service.weather.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.service.BaseImpl;
import com.why.newsbeat.service.weather.bean.WeatherBean;
import com.why.newsbeat.service.weather.event.WeatherEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/9/14.
 */

public class WeatherImpl extends BaseImpl<WeatherService> implements WeatherApi{


	@Override
	public void loadWeather(String cityName) {

		mService.getWeather(cityName, NetUrl.WEATHER_API_KEY)
				.subscribeOn(Schedulers.newThread())//新线程调用，
				.observeOn(AndroidSchedulers.mainThread())//主线程回调
				.subscribe(new Observer<WeatherBean>() {
					@Override
					public void onCompleted() {
						LogUtils.i("onCompleted...");
					}

					@Override
					public void onError(Throwable e) {
						LogUtils.i("onError:"+e.getMessage());
						EventBus.getDefault().post(new WeatherEvent(null).setAvailable(false));
					}

					@Override
					public void onNext(WeatherBean weatherBean) {
						LogUtils.i("onNext:");
						EventBus.getDefault().post(new WeatherEvent(weatherBean));
					}
				});


	}
}
