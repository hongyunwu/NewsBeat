package com.why.newsbeat.service.shishang.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.shishang.bean.ShiShangBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class ShiShangNewsEvent extends BaseEvent<ShiShangBean> {

	public ShiShangNewsEvent(ShiShangBean mEvent) {
		super(mEvent);
	}
}
