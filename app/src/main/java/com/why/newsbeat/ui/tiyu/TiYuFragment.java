package com.why.newsbeat.ui.tiyu;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.tiyu.bean.TiYuBean;
import com.why.newsbeat.base.tiyu.event.TiYuNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class TiYuFragment extends BaseFragment<TiYuViewHolder> {
	private boolean isRefreshing;
	private TiYuViewAdapter tiYuViewAdapter;


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
		NewsBeat.loadTiYuNews();
	}

	/**
	 * 当体育新闻加载完成时回调
	 *
	 * @param tiYuNewsEvent
	 */
	@Subscribe
	public void onLoadTiYuNews(TiYuNewsEvent tiYuNewsEvent){
		if (tiYuNewsEvent.isAvailable()){
			if (tiYuViewAdapter==null){
				tiYuViewAdapter = new TiYuViewAdapter(getContext(), tiYuNewsEvent.getEvent().getResult().getData());
				tiYuViewAdapter.setOnItemClickListener(new TiYuViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, TiYuBean.ResultBean.DataBean dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(tiYuViewAdapter);
			}else {

				if (isRefreshing){
					tiYuViewAdapter.setData(tiYuNewsEvent.getEvent().getResult().getData());
				}else {
					tiYuViewAdapter.addData(tiYuNewsEvent.getEvent().getResult().getData());
				}

				tiYuViewAdapter.notifyDataSetChanged();
			}
		}else {

		}

		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
