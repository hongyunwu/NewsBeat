package com.why.newsbeat.ui.junshi;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.junshi.bean.JunShiBean;
import com.why.newsbeat.base.junshi.event.JunShiNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class JunShiFragment extends BaseFragment<JunShiViewHolder> {
	private boolean isRefreshing;
	private JunShiViewAdapter junShiViewAdapter;

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
		NewsBeat.loadJunShiNews();
	}

	/**
	 * 当军事新闻加载完成时回调
	 *
	 * @param junShiNewsEvent
	 */
	@Subscribe
	public void onLoadJunShiNews(JunShiNewsEvent junShiNewsEvent){
		if (junShiNewsEvent.isAvailable()){

			if(junShiViewAdapter==null){
				junShiViewAdapter = new JunShiViewAdapter(getContext(), junShiNewsEvent.getEvent().getResult().getData());
				junShiViewAdapter.setOnItemClickListener(new JunShiViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, JunShiBean.ResultBean.DataBean dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(junShiViewAdapter);
			}else {

				if (isRefreshing){
					junShiViewAdapter.setData(junShiNewsEvent.getEvent().getResult().getData());
				}else {
					junShiViewAdapter.addData(junShiNewsEvent.getEvent().getResult().getData());
				}
				junShiViewAdapter.notifyDataSetChanged();
			}
		}else {

		}

		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
