package com.why.newsbeat.ui.caijing;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.caijing.bean.CaiJingBean;
import com.why.newsbeat.base.caijing.event.CaiJingNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class CaiJingFragment extends BaseFragment<CaiJingViewHolder> {
	private boolean isRefreshing;
	private CaiJingViewAdapter caiJingViewAdapter;


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
		NewsBeat.loadCaiJingNews();
	}

	/**
	 * 当财经新闻加载完成时回调
	 *
	 * @param caiJingNewsEvent
	 */
	@Subscribe
	public void onLoadCaiJingNews(CaiJingNewsEvent caiJingNewsEvent){
		caiJingViewAdapter = new CaiJingViewAdapter(getContext(), caiJingNewsEvent.getEvent().getResult().getData());
		caiJingViewAdapter.setOnItemClickListener(new CaiJingViewAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position, CaiJingBean.ResultBean.DataBean dataBean) {
				Bundle bundle = new Bundle();
				bundle.putParcelable("news",dataBean);
				gotoSubActivity(NewsDetailActivity.class,bundle,false);
			}
		});

		viewHolder.recycler_view.setAdapter(caiJingViewAdapter);
		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
