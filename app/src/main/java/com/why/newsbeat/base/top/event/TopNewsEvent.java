package com.why.newsbeat.base.top.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.top.bean.TopBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class TopNewsEvent extends BaseEvent<TopBean> {

	public TopNewsEvent(TopBean mEvent) {
		super(mEvent);
	}
}
