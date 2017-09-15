package com.why.newsbeat.ui.history;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.why.base.ui.BaseActivity;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.collect.event.CollectNewsEvent;
import com.why.newsbeat.base.history.bean.History;
import com.why.newsbeat.base.history.event.HistoryNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

public class HistoryActivity extends BaseActivity<HistoryViewHolder> {

	/**
	 * 当前是否正在刷新
	 */
	private boolean isRefreshing;
	private HistoryViewAdapter historyViewAdapter;

	@Override
	public int getLayoutID() {
		return R.layout.activity_collect;
	}

	@Override
	public void initData() {

		initToolBar();
		//执行一个线程获取历史列表
		viewHolder.tool_bar_title.setText(viewHolder.my_histories);
		viewHolder.swipe_refresh.setColorSchemeResources(R.color.colorPrimary);
		viewHolder.recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
		viewHolder.recycler_view.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
		viewHolder.swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				if (!isRefreshing){
					isRefreshing = true;
					loadData();
				}
			}
		});
		//暂时只加载第一页
		loadData();
	}

	private void initToolBar() {
		setSupportActionBar(viewHolder.tool_bar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle("");
	}

	private void loadData() {
		NewsBeat.loadHistories(20,0);
	}

	/**
	 * 加载足迹回调
	 *
	 * @param historyNewsEvent
	 */
	@Subscribe
	public void loadHistories(HistoryNewsEvent historyNewsEvent){

		historyViewAdapter = new HistoryViewAdapter(this, historyNewsEvent.getEvent());
		historyViewAdapter.setOnItemClickListener(new HistoryViewAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position, History dataBean) {
				Bundle bundle = new Bundle();
				bundle.putParcelable("news",dataBean);
				gotoSubActivity(NewsDetailActivity.class,bundle,false);
			}
		});
		viewHolder.recycler_view.setAdapter(historyViewAdapter);
		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home:

				finish();
				break;

		}

		return super.onOptionsItemSelected(item);
	}
}
