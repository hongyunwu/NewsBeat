package com.why.newsbeat.service.yule.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.service.BaseImpl;
import com.why.newsbeat.service.yule.bean.YuLeBean;
import com.why.newsbeat.service.yule.event.YuLeNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class YuLeImpl extends BaseImpl<YuLeService> implements YuLeApi {


	@Override
	public void loadYuLeNews() {

		mService.getYuLeNews("yule", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<YuLeBean>() {

					@Override
					public void onNext(YuLeBean yuLeBean) {
						EventBus.getDefault().post(new YuLeNewsEvent(yuLeBean));
					}

					@Override
					public void onCompleted() {
						LogUtils.i("onComplete");
					}

					@Override
					public void onError(Throwable e) {
						LogUtils.i("onError:"+e.getMessage());
						EventBus.getDefault().post(new YuLeNewsEvent(null).setAvailable(false));
					}
				});
	}
}
