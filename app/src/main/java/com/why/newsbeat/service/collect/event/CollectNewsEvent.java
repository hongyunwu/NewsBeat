package com.why.newsbeat.service.collect.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.collect.bean.Collect;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */

public class CollectNewsEvent extends BaseEvent<List<Collect>> {

	public CollectNewsEvent(List<Collect> mEvent) {
		super(mEvent);
	}

}
