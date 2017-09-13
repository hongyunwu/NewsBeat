package com.why.newsbeat.ui.guiji;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.guoji.bean.GuoJiBean;
import com.why.newsbeat.base.guoji.event.GuoJiNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class GuoJiFragment extends BaseFragment<GuoJiViewHolder> {
	private boolean isRefreshing;
	private GuoJiViewAdapter guoJiViewAdapter;

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
		NewsBeat.loadGuoJiNews();
	}

	/**
	 * 当国际新闻加载完成时回调
	 *
	 * @param guoJiNewsEvent
	 */
	@Subscribe
	public void onLoadGuoJiNews(GuoJiNewsEvent guoJiNewsEvent){
		guoJiViewAdapter = new GuoJiViewAdapter(getContext(), guoJiNewsEvent.getEvent().getResult().getData());
		guoJiViewAdapter.setOnItemClickListener(new GuoJiViewAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position, GuoJiBean.ResultBean.DataBean dataBean) {
				Bundle bundle = new Bundle();
				bundle.putParcelable("news",dataBean);
				gotoSubActivity(NewsDetailActivity.class,bundle,false);
			}
		});
		viewHolder.recycler_view.setAdapter(guoJiViewAdapter);
		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
