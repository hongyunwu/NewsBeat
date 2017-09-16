package com.why.newsbeat.ui.collect;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/15.
 */

public class CollectViewHolder extends BaseHolder {
	@BindView(R.id.recycler_view)
	RecyclerView recycler_view;
	@BindView(R.id.swipe_refresh)
	SwipeRefreshLayout swipe_refresh;
	@BindView(R.id.tool_bar_title)
	TextView tool_bar_title;
	@BindView(R.id.tool_bar)
	Toolbar tool_bar;
	@BindString(R.string.my_collections)
	String 	my_collections;

	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public CollectViewHolder(View itemView) {
		super(itemView);
	}
}
