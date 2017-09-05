package com.why.newsbeat.base.yule.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.yule.bean.YuLeBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class YuLeNewsEvent extends BaseEvent<YuLeBean> {

	public YuLeNewsEvent(YuLeBean mEvent) {
		super(mEvent);
	}
}
