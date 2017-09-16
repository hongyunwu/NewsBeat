package com.why.newsbeat.service.shehui.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.shehui.bean.SheHuiBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class SheHuiNewsEvent extends BaseEvent<SheHuiBean> {

	public SheHuiNewsEvent(SheHuiBean mEvent) {
		super(mEvent);
	}
}
