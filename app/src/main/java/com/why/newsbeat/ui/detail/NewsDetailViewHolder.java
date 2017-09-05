package com.why.newsbeat.ui.detail;

import android.view.View;

import com.tencent.smtt.sdk.WebView;
import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/4.
 */
public class NewsDetailViewHolder extends BaseHolder{

	@BindView(R.id.news_detail)
	WebView news_detail;
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public NewsDetailViewHolder(View itemView) {
		super(itemView);
	}
}
