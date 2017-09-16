package com.why.newsbeat.ui.guonei;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.service.NewsBeat;
import com.why.newsbeat.service.guonei.bean.GuoNeiBean;
import com.why.newsbeat.service.guonei.event.GuoNeiNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class GuoNeiFragment extends BaseFragment<GuoNeiViewHolder> {
	private boolean isRefreshing;
	private GuoNeiViewAdapter guoNeiViewAdapter;

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
		NewsBeat.loadGuoNeiNews();
	}

	/**
	 * 当国内新闻加载完成时回调
	 *
	 * @param guoNeiNewsEvent
	 */
	@Subscribe
	public void onLoadGuoNeiNews(GuoNeiNewsEvent guoNeiNewsEvent){
		if (guoNeiNewsEvent.isAvailable()){
			if(guoNeiViewAdapter==null){
				guoNeiViewAdapter = new GuoNeiViewAdapter(getContext(), guoNeiNewsEvent.getEvent().getResult().getData());
				guoNeiViewAdapter.setOnItemClickListener(new GuoNeiViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, GuoNeiBean.ResultBean.DataBean dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(guoNeiViewAdapter);

			}else {
				if (isRefreshing){
					guoNeiViewAdapter.setData(guoNeiNewsEvent.getEvent().getResult().getData());
				}else {
					guoNeiViewAdapter.setData(guoNeiNewsEvent.getEvent().getResult().getData());
				}
				guoNeiViewAdapter.setData(guoNeiNewsEvent.getEvent().getResult().getData());
				guoNeiViewAdapter.notifyDataSetChanged();
			}
		}else {

		}


		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
