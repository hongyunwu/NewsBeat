package com.why.newsbeat.ui.keji;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/3.
 */
public class KeJiItemViewHolder extends BaseHolder {

	@BindView(R.id.item_top_news)
	LinearLayout item_top_news;
	@BindView(R.id.title)
	TextView title;
	@BindView(R.id.comments)
	TextView comments;
	@BindView(R.id.author)
	TextView author;
	@BindView(R.id.thumb_01)
	ImageView thumb_01;

	ImageView thumb_02;
	ImageView thumb_03;
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public KeJiItemViewHolder(View itemView) {
		super(itemView);
		thumb_02 = (ImageView) itemView.findViewById(R.id.thumb_02);
		thumb_03 = (ImageView) itemView.findViewById(R.id.thumb_03);
	}
}
