package com.why.newsbeat.ui.detail;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebView;
import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/4.
 */
public class NewsDetailViewHolder extends BaseHolder{

	@BindView(R.id.comments_bar)
	Toolbar comments_bar;
	@BindView(R.id.write_comments)
	Button write_comments;
	@BindView(R.id.tool_bar)
	Toolbar tool_bar;
	@BindView(R.id.progress)
	ProgressBar progress;
	@BindView(R.id.news_detail)
	WebView news_detail;
	@BindView(R.id.author_name)
	TextView author_name;
	@BindView(R.id.date)
	TextView date;
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public NewsDetailViewHolder(View itemView) {
		super(itemView);
	}
}
