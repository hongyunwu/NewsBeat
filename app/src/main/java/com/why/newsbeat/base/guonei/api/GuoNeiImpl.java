package com.why.newsbeat.base.guonei.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.guonei.bean.GuoNeiBean;
import com.why.newsbeat.base.guonei.event.GuoNeiNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class GuoNeiImpl extends BaseImpl<GuoNeiService> implements GuoNeiApi {


	@Override
	public void loadGuoNeiNews() {

		mService.getGuoNeiNews("guonei", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<GuoNeiBean>() {

					@Override
					public void onNext(GuoNeiBean guoNeiBean) {
						EventBus.getDefault().post(new GuoNeiNewsEvent(guoNeiBean));
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
