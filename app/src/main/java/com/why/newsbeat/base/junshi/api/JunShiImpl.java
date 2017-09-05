package com.why.newsbeat.base.junshi.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.junshi.bean.JunShiBean;
import com.why.newsbeat.base.junshi.event.JunShiNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class JunShiImpl extends BaseImpl<JunShiService> implements JunShiApi {


	@Override
	public void loadJunShiNews() {

		mService.getJunShiNews("junshi", NetUrl.API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<JunShiBean>() {

					@Override
					public void onNext(JunShiBean junShiBean) {
						EventBus.getDefault().post(new JunShiNewsEvent(junShiBean));
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
