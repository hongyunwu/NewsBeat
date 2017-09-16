package com.why.newsbeat.base.caijing.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.base.caijing.bean.CaiJingBean;

/**
 * Created by lenovo on 2017/9/3.
 */

public class CaiJingNewsEvent extends BaseEvent<CaiJingBean> {


	public CaiJingNewsEvent(CaiJingBean mEvent) {
		super(mEvent);
	}

	public CaiJingNewsEvent(CaiJingBean mEvent, boolean mAvailable) {
		super(mEvent, mAvailable);
	}
}
