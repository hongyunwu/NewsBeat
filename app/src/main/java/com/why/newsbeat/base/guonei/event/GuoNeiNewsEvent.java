package com.why.newsbeat.base.guonei.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.guonei.bean.GuoNeiBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class GuoNeiNewsEvent extends BaseEvent<GuoNeiBean> {

	public GuoNeiNewsEvent(GuoNeiBean mEvent) {
		super(mEvent);
	}
}
