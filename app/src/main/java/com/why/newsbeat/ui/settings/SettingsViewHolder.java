package com.why.newsbeat.ui.settings;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/15.
 */

public class SettingsViewHolder extends BaseHolder {

	@BindView(R.id.tool_bar)
	Toolbar tool_bar;
	@BindView(R.id.tool_bar_title)
	TextView tool_bar_title;
	@BindString(R.string.my_settings)
	String my_settings;

	String content_pic_mode ="content_pic_mode";

	String text_size_mode = "text_size_mode";

	String about_us = "about_us";

	String message_notification = "message_notification";
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public SettingsViewHolder(View itemView) {
		super(itemView);
	}
}
