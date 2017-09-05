package com.why.newsbeat.base.keji.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.keji.bean.KeJiBean;
import com.why.newsbeat.base.keji.event.KeJiNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class KeJiImpl extends BaseImpl<KeJiService> implements KeJiApi {


	@Override
	public void loadKeJiNews() {

		mService.getkeJiNews("keji", NetUrl.API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<KeJiBean>() {

					@Override
					public void onNext(KeJiBean keJiBean) {
						EventBus.getDefault().post(new KeJiNewsEvent(keJiBean));
					}

					@Override
					public void onCompleted() {
						LogUtils.i("onComplete");
					}

					@Override
					public void onError(Throwable e) {
						LogUtils.i("onError:"+e.getMessage());
					}
				});
	}
}
