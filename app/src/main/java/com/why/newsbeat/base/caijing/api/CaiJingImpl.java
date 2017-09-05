package com.why.newsbeat.base.caijing.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.caijing.bean.CaiJingBean;
import com.why.newsbeat.base.caijing.event.CaiJingNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class CaiJingImpl extends BaseImpl<CaiJingService> implements CaiJingApi {


	@Override
	public void loadCaiJingNews() {

		mService.getCaiJingNews("caijing", NetUrl.API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<CaiJingBean>() {

					@Override
					public void onNext(CaiJingBean caiJingBean) {
						EventBus.getDefault().post(new CaiJingNewsEvent(caiJingBean));
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
