package com.why.newsbeat.ui.settings;

import android.view.MenuItem;

import com.why.base.ui.BaseActivity;
import com.why.newsbeat.R;

public class SettingsActivity extends BaseActivity<SettingsViewHolder> {


	@Override
	public int getLayoutID() {
		return R.layout.activity_settings;
	}

	@Override
	public void initData() {
		initToolBar();


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
}
