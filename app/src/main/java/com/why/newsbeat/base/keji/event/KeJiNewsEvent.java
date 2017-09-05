package com.why.newsbeat.base.keji.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.keji.bean.KeJiBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class KeJiNewsEvent extends BaseEvent<KeJiBean> {

	public KeJiNewsEvent(KeJiBean mEvent) {
		super(mEvent);
	}
}
