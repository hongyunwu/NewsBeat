package com.why.newsbeat.service.history.event;

import com.why.base.event.BaseEvent;
import com.why.newsbeat.service.history.bean.History;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */

public class HistoryNewsEvent extends BaseEvent<List<History>> {

	public HistoryNewsEvent(List<History> mEvent) {
		super(mEvent);
	}

}
