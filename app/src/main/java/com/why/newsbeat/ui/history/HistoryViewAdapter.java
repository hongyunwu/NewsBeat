package com.why.newsbeat.ui.history;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.why.newsbeat.GlideApp;
import com.why.newsbeat.R;
import com.why.newsbeat.dao.manager.DBManager;
import com.why.newsbeat.service.history.bean.History;

import java.util.List;

/**
 * Created by lenovo on 2017/9/3.
 */
public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryItemViewHolder> {


	public static final int ITEM_TYPE_THUMB1 = 1;
	public static final int ITEM_TYPE_THUMB3 = 2;

	private List<History> mData;
	private Context mContext;

	public HistoryViewAdapter(Context context, List<History> data) {
		this.mContext = context;
		this.mData = data;
	}
	public void setData(@NonNull List<History> data) {
		this.mData = data;

	}
	public void addData(@NonNull List<History> data){
		if (mData==null){
			mData = data;
		}else {
			mData.addAll(data);
		}
	}

	@Override
	public int getItemViewType(int position) {
		History dataBean = mData.get(position);
		if (TextUtils.isEmpty(dataBean.getThumbnail_pic_s02())
				|| TextUtils.isEmpty(dataBean.getThumbnail_pic_s03())) {
			return ITEM_TYPE_THUMB1;
		}
		return ITEM_TYPE_THUMB3;
	}

	@Override
	public HistoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		int layoutId = 0;
		if (viewType == ITEM_TYPE_THUMB1) {
			layoutId = R.layout.item_top_news1;
		} else if (viewType == ITEM_TYPE_THUMB3) {
			layoutId = R.layout.item_top_news3;
		}
		final HistoryItemViewHolder topItemViewHolder = new HistoryItemViewHolder(LayoutInflater.from(mContext).inflate(layoutId, parent, false));
		topItemViewHolder.setListeners(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = topItemViewHolder.getAdapterPosition();
				//点击的位置

				switch (v.getId()){
					case R.id.item_top_news:
						if (onItemClickListener!=null){
							onItemClickListener.onItemClick(position,mData.get(position));
						}
						break;
					case R.id.delete:
						History history = mData.remove(position);
						notifyItemRemoved(position);
						DBManager.delete(mContext,history);
						break;
				}


			}
		},topItemViewHolder.item_top_news,topItemViewHolder.delete);

		return topItemViewHolder;
	}

	@Override
	public void onBindViewHolder(HistoryItemViewHolder holder, int position) {
		History dataBean = mData.get(position);

		holder.title.setText(dataBean.getTitle());
		holder.author.setText(dataBean.getAuthor_name());
		if (getItemViewType(position)==ITEM_TYPE_THUMB3){
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s()).into(holder.thumb_01);
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s02()).into(holder.thumb_02);
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s03()).into(holder.thumb_03);
		}else {
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s()).into(holder.thumb_01);
		}

	}

	@Override
	public int getItemCount() {
		if (mData != null) {
			return mData.size();
		}
		return 0;
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	private OnItemClickListener onItemClickListener;
	public interface OnItemClickListener{
		void onItemClick(int position, History dataBean);
	}
}
