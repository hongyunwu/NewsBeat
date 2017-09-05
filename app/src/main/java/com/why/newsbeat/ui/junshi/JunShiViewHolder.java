package com.why.newsbeat.ui.junshi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/3.
 */

public class JunShiViewHolder extends BaseHolder {

	@BindView(R.id.recycler_view)
	public RecyclerView recycler_view;
	@BindView(R.id.swipe_refresh)
	public SwipeRefreshLayout swipe_refresh;
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public JunShiViewHolder(View itemView) {
		super(itemView);
	}
}
