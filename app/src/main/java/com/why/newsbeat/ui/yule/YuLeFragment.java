package com.why.newsbeat.ui.yule;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.yule.bean.YuLeBean;
import com.why.newsbeat.base.yule.event.YuLeNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class YuLeFragment extends BaseFragment<YuLeViewHolder> {
	private boolean isRefreshing;
	private YuLeViewAdapter yuLeViewAdapter;


	@Override
	public int getLayoutID() {
		return R.layout.fragment_news;
	}

	@Override
	public void initData() {

		viewHolder.swipe_refresh.setColorSchemeResources(R.color.colorPrimary);
		viewHolder.recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
		viewHolder.recycler_view.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		viewHolder.swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				if (!isRefreshing){
					isRefreshing = true;
					loadData();
				}
			}
		});
		loadData();
	}

	private void loadData() {
		NewsBeat.loadYuLeNews();
	}

	/**
	 * 当体育新闻加载完成时回调
	 *
	 * @param yuLeNewsEvent
	 */
	@Subscribe
	public void onLoadYuLeNews(YuLeNewsEvent yuLeNewsEvent){
		yuLeViewAdapter = new YuLeViewAdapter(getContext(), yuLeNewsEvent.getEvent().getResult().getData());
		yuLeViewAdapter.setOnItemClickListener(new YuLeViewAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position, YuLeBean.ResultBean.DataBean dataBean) {
				Bundle bundle = new Bundle();
				bundle.putString("news",dataBean.getUrl());
				gotoSubActivity(NewsDetailActivity.class,bundle,false);
			}
		});
		viewHolder.recycler_view.setAdapter(yuLeViewAdapter);
		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
