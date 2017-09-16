package com.why.newsbeat.base.guoji.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.guoji.bean.GuoJiBean;
import com.why.newsbeat.base.guoji.event.GuoJiNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class GuoJiImpl extends BaseImpl<GuoJiService> implements GuoJiApi {


	@Override
	public void loadGuoJiNews() {

		mService.getGuoJiNews("guoji", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<GuoJiBean>() {

					@Override
					public void onNext(GuoJiBean guoJiBean) {
						EventBus.getDefault().post(new GuoJiNewsEvent(guoJiBean));
					}

					@Override
					public void onCompleted() {
						LogUtils.i("onComplete");
					}

					@Override
					public void onError(Throwable e) {
						LogUtils.i("onError:"+e.getMessage());
						EventBus.getDefault().post(new GuoJiNewsEvent(null).setAvailable(false));
					}
				});
	}
}
