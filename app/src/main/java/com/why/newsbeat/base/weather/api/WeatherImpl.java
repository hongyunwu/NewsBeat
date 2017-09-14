package com.why.newsbeat.base.weather.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.top.bean.TopBean;
import com.why.newsbeat.base.weather.bean.WeatherBean;
import com.why.newsbeat.base.weather.event.WeatherEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/9/14.
 */

public class WeatherImpl extends BaseImpl<WeatherService> implements WeatherApi{


	@Override
	public void loadWeather() {

		mService.getWeather("上海", NetUrl.WEATHER_API_KEY)
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
					}

					@Override
					public void onNext(WeatherBean weatherBean) {
						LogUtils.i("onNext:");
						EventBus.getDefault().post(new WeatherEvent(weatherBean));
					}
				});


	}
}
