package com.why.newsbeat.base.shehui.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.shehui.bean.SheHuiBean;
import com.why.newsbeat.base.top.bean.TopBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class SheHuiNewsEvent extends BaseEvent<SheHuiBean> {

	public SheHuiNewsEvent(SheHuiBean mEvent) {
		super(mEvent);
	}
}
