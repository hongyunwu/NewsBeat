package com.why.newsbeat.service.top.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.top.bean.TopBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class TopNewsEvent extends BaseEvent<TopBean> {

	public TopNewsEvent(TopBean mEvent) {
		super(mEvent);
	}
}
