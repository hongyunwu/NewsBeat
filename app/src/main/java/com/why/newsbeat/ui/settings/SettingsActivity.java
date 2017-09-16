package com.why.newsbeat.ui.settings;

import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.MenuItem;

import com.why.base.ui.BaseActivity;
import com.why.base.ui.BaseSettingsActivity;
import com.why.base.utils.LogUtils;
import com.why.newsbeat.R;

public class SettingsActivity extends BaseSettingsActivity<SettingsViewHolder> {


	@Override
	protected int getToolBarId() {
		return R.layout.tool_bar;
	}

	@Override
	public void initData() {
		initToolBar();
	}

	@Override
	public int getXmlId() {
		return R.xml.preference;
	}

	private void initToolBar() {
		setSupportActionBar(viewHolder.tool_bar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("");
		viewHolder.tool_bar_title.setText(viewHolder.my_settings);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
		String key = preference.getKey();
		//
		if (viewHolder.content_pic_mode.equals(key)){//图文莫斯

		}else if (viewHolder.message_notification.equals(key)){//消息通知

		}else if (viewHolder.about_us.equals(key)){//关于我们

		}else if (viewHolder.text_size_mode.equals(key)){//字体大小

		}
		LogUtils.i("onPreferenceTreeClick:"+key);
		super.onPreferenceTreeClick(preferenceScreen, preference);
	}
}
