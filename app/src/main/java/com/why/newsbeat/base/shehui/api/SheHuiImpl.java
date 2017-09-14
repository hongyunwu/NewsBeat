package com.why.newsbeat.base.shehui.api;

import com.why.base.utils.LogUtils;
import com.why.newsbeat.NetUrl;
import com.why.newsbeat.base.BaseImpl;
import com.why.newsbeat.base.shehui.bean.SheHuiBean;
import com.why.newsbeat.base.shehui.event.SheHuiNewsEvent;

import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenovo on 2017/9/2.
 */

public class SheHuiImpl extends BaseImpl<SheHuiService> implements SheHuiApi {


	@Override
	public void loadSheHuiNews() {

		mService.getSheHuiNews("shehui", NetUrl.NEWS_API_KEY)
				.subscribeOn(Schedulers.newThread())//在新线程中调用
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<SheHuiBean>() {

					@Override
					public void onNext(SheHuiBean sheHuiBean) {
						EventBus.getDefault().post(new SheHuiNewsEvent(sheHuiBean));
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
