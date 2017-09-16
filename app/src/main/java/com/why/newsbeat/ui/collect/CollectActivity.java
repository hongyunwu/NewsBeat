package com.why.newsbeat.ui.collect;

import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.why.base.ui.BaseActivity;
import com.why.newsbeat.R;
import com.why.newsbeat.service.NewsBeat;
import com.why.newsbeat.service.collect.event.CollectNewsEvent;
import com.why.newsbeat.service.collect.bean.Collect;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

public class CollectActivity extends BaseActivity<CollectViewHolder> {

	/**
	 * 当前是否正在刷新
	 */
	private boolean isRefreshing;
	private CollectViewAdapter collectViewAdapter;

	@Override
	public int getLayoutID() {
		return R.layout.activity_collect;
	}

	@Override
	public void initData() {

		initToolBar();
		//执行一个线程获取收藏列表
		viewHolder.tool_bar_title.setText(viewHolder.my_collections);
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
		isRefreshing = true;
		viewHolder.swipe_refresh.setRefreshing(true);
		NewsBeat.loadCollections(20,0);
	}

	/**
	 * 加载收藏回调
	 *
	 * @param collectNewsEvent
	 */
	@Subscribe
	public void loadCollections(CollectNewsEvent collectNewsEvent){
		if (collectNewsEvent.isAvailable()){
			if (collectViewAdapter==null){
				collectViewAdapter = new CollectViewAdapter(this, collectNewsEvent.getEvent());
				collectViewAdapter.setOnItemClickListener(new CollectViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, Collect dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(collectViewAdapter);
			}else{

				if (isRefreshing){
					collectViewAdapter.setData(collectNewsEvent.getEvent());
				}else {
					collectViewAdapter.addData(collectNewsEvent.getEvent());
				}

				collectViewAdapter.notifyDataSetChanged();
			}
		}else{

		}

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
