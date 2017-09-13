package com.why.newsbeat.ui.shishang;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.shishang.bean.ShiShangBean;
import com.why.newsbeat.base.shishang.event.ShiShangNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class ShiShangFragment extends BaseFragment<ShiShangViewHolder> {
	private boolean isRefreshing;
	private ShiShangViewAdapter shiShangViewAdapter;


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
		NewsBeat.loadShiShangNews();
	}

	/**
	 * 当时尚新闻加载完成时回调
	 *
	 * @param shiShangNewsEvent
	 */
	@Subscribe
	public void onLoadShiShangNews(ShiShangNewsEvent shiShangNewsEvent){
		shiShangViewAdapter = new ShiShangViewAdapter(getContext(), shiShangNewsEvent.getEvent().getResult().getData());
		shiShangViewAdapter.setOnItemClickListener(new ShiShangViewAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position, ShiShangBean.ResultBean.DataBean dataBean) {
				Bundle bundle = new Bundle();
				bundle.putParcelable("news",dataBean);
				gotoSubActivity(NewsDetailActivity.class,bundle,false);
			}
		});
		viewHolder.recycler_view.setAdapter(shiShangViewAdapter);
		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
