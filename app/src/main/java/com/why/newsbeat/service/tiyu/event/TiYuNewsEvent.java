package com.why.newsbeat.service.tiyu.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.tiyu.bean.TiYuBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class TiYuNewsEvent extends BaseEvent<TiYuBean> {

	public TiYuNewsEvent(TiYuBean mEvent) {
		super(mEvent);
	}
}
