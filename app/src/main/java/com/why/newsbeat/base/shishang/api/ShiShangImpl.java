package com.why.newsbeat.base.shishang.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.shishang.bean.ShiShangBean;
import com.why.newsbeat.base.shishang.event.ShiShangNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class ShiShangImpl extends BaseImpl<ShiShangService> implements ShiShangApi {


	@Override
	public void loadShiShangNews() {

		mService.getShiShangNews("shishang", NetUrl.API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ShiShangBean>() {

					@Override
					public void onNext(ShiShangBean shiShangBean) {
						EventBus.getDefault().post(new ShiShangNewsEvent(shiShangBean));
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
