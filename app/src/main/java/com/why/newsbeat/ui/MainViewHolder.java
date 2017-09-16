package com.why.newsbeat.ui;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/2.
 */

public class MainViewHolder extends BaseHolder {

	@BindView(R.id.tool_bar)
	Toolbar tool_bar;
	@BindView(R.id.navigation_view)
	NavigationView navigation_view;
	@BindView(R.id.main_drawer)
	DrawerLayout main_drawer;
	@BindView(R.id.tab_bar)
	TabLayout tab_bar;
	@BindView(R.id.view_pager)
	ViewPager view_pager;

	ImageView weather_pic;
	TextView wind;
	TextView humidity;
	TextView temp;

	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public MainViewHolder(View itemView) {
		super(itemView);
	}
}
