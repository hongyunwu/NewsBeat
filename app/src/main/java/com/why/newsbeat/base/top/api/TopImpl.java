package com.why.newsbeat.base.top.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.top.event.TopNewsEvent;
import com.why.newsbeat.base.top.bean.TopBean;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class TopImpl extends BaseImpl<TopService> implements TopApi {


	@Override
	public void loadATopNews() {

		mService.getTopNews("top", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<TopBean>() {

					@Override
					public void onNext(TopBean topBean) {
						EventBus.getDefault().post(new TopNewsEvent(topBean));
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
