package com.why.newsbeat.service.tiyu.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.service.BaseImpl;
import com.why.newsbeat.service.tiyu.bean.TiYuBean;
import com.why.newsbeat.service.tiyu.event.TiYuNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class TiYuImpl extends BaseImpl<TiYuService> implements TiYuApi {


	@Override
	public void loadTiYuNews() {

		mService.getTiYuNews("tiyu", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<TiYuBean>() {

					@Override
					public void onNext(TiYuBean tiYuBean) {
						EventBus.getDefault().post(new TiYuNewsEvent(tiYuBean));
					}

					@Override
					public void onCompleted() {
						LogUtils.i("onComplete");
					}

					@Override
					public void onError(Throwable e) {
						LogUtils.i("onError:"+e.getMessage());
						EventBus.getDefault().post(new TiYuNewsEvent(null).setAvailable(false));
					}
				});
	}
}
