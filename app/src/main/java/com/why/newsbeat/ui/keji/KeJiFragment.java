package com.why.newsbeat.ui.keji;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.keji.bean.KeJiBean;
import com.why.newsbeat.base.keji.event.KeJiNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class KeJiFragment extends BaseFragment<KeJiViewHolder> {
	private boolean isRefreshing;
	private KeJiViewAdapter keJiViewAdapter;

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
		isRefreshing = true;
		viewHolder.swipe_refresh.setRefreshing(true);
		NewsBeat.loadKeJiNews();
	}

	/**
	 * 当科技新闻加载完成时回调
	 *
	 * @param keJiNewsEvent
	 */
	@Subscribe
	public void onLoadKeJiNews(KeJiNewsEvent keJiNewsEvent){
		if (keJiNewsEvent.isAvailable()){
			if (keJiViewAdapter==null){
				keJiViewAdapter = new KeJiViewAdapter(getContext(), keJiNewsEvent.getEvent().getResult().getData());
				keJiViewAdapter.setOnItemClickListener(new KeJiViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, KeJiBean.ResultBean.DataBean dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(keJiViewAdapter);
			}else {
				if (isRefreshing){
					keJiViewAdapter.setData(keJiNewsEvent.getEvent().getResult().getData());
				}else {
					keJiViewAdapter.addData(keJiNewsEvent.getEvent().getResult().getData());
				}

				keJiViewAdapter.notifyDataSetChanged();
			}

		}else {

		}

		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
