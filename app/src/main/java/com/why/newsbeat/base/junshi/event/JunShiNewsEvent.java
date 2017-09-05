package com.why.newsbeat.base.junshi.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.junshi.bean.JunShiBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class JunShiNewsEvent extends BaseEvent<JunShiBean> {

	public JunShiNewsEvent(JunShiBean mEvent) {
		super(mEvent);
	}
}
