package com.why.newsbeat.service.guoji.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.guoji.bean.GuoJiBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class GuoJiNewsEvent extends BaseEvent<GuoJiBean> {

	public GuoJiNewsEvent(GuoJiBean mEvent) {
		super(mEvent);
	}
}
