package com.why.newsbeat.ui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.why.base.cache.AppCache;
import com.why.base.cache.ImageCache;
import com.why.base.ui.BaseActivity;
import com.why.base.ui.BaseFragment;
import com.why.base.utils.LogUtils;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.weather.event.WeatherEvent;
import com.why.newsbeat.ui.caijing.CaiJingFragment;
import com.why.newsbeat.ui.collect.CollectActivity;
import com.why.newsbeat.ui.guiji.GuoJiFragment;
import com.why.newsbeat.ui.guonei.GuoNeiFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.ui.history.HistoryActivity;
import com.why.newsbeat.ui.junshi.JunShiFragment;
import com.why.newsbeat.ui.keji.KeJiFragment;
import com.why.newsbeat.ui.settings.SettingsActivity;
import com.why.newsbeat.ui.shehui.SheHuiFragment;
import com.why.newsbeat.ui.shishang.ShiShangFragment;
import com.why.newsbeat.ui.tiyu.TiYuFragment;
import com.why.newsbeat.ui.top.TopFragment;
import com.why.newsbeat.ui.yule.YuLeFragment;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * 主页
 */
public class MainActivity extends BaseActivity<MainViewHolder> implements NavigationView.OnNavigationItemSelectedListener {


	public String[] tabTitles = new String[]{
			"头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"
	};
	private ArrayList<BaseFragment> mFragments = new ArrayList<>();

	@Override
	public int getLayoutID() {
		return R.layout.activity_main;
	}

	@Override
	public int getMenuId() {
		return R.menu.menu;
	}

	@Override
	public void initData() {
		initToolBar();
		initNavigationView();
		initDrawer();
		initTabBar();
	}


	/**
	 * 初始化标签栏
	 */
	private void initTabBar() {
		for (int i = 0; i < tabTitles.length; i++) {
			viewHolder.tab_bar.addTab(viewHolder.tab_bar.newTab().setText(tabTitles[i]));
		}
		viewHolder.tab_bar.setTabMode(TabLayout.MODE_SCROLLABLE);
		mFragments.add(new TopFragment());
		mFragments.add(new SheHuiFragment());
		mFragments.add(new GuoNeiFragment());
		mFragments.add(new GuoJiFragment());
		mFragments.add(new YuLeFragment());
		mFragments.add(new TiYuFragment());
		mFragments.add(new JunShiFragment());
		mFragments.add(new KeJiFragment());
		mFragments.add(new CaiJingFragment());
		mFragments.add(new ShiShangFragment());
		viewHolder.view_pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragments, tabTitles));
		viewHolder.tab_bar.setupWithViewPager(viewHolder.view_pager);

	}

	/**
	 * 初始化侧滑布局
	 */
	private void initDrawer() {
		ActionBarDrawerToggle drawerToggle
				= new ActionBarDrawerToggle(this, viewHolder.main_drawer, viewHolder.tool_bar, R.string.open_drawer, R.string.close_drawer) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				LogUtils.i("onDrawerClosed");
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				LogUtils.i("onDrawerOpened");
			}
		};
		drawerToggle.syncState();
		viewHolder.main_drawer.addDrawerListener(drawerToggle);
	}

	/**
	 * 初始化侧滑菜单栏
	 */
	private void initNavigationView() {
		NewsBeat.loadWeather("上海");
		viewHolder.navigation_view.setItemIconTintList(null);
		NavigationMenuView navigationMenuView = (NavigationMenuView) viewHolder.navigation_view.getChildAt(0);
		if (navigationMenuView != null) {
			navigationMenuView.setVerticalScrollBarEnabled(false);
			navigationMenuView.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		}
		viewHolder.navigation_view.setNavigationItemSelectedListener(this);
		View headerView = viewHolder.navigation_view.getHeaderView(0);
		viewHolder.temp = (TextView) headerView.findViewById(R.id.temp);
		viewHolder.wind = (TextView) headerView.findViewById(R.id.wind);
		viewHolder.humidity = (TextView) headerView.findViewById(R.id.humidity);
		viewHolder.weather_pic = (ImageView) headerView.findViewById(R.id.weather_pic);
	}

	/**
	 * 初始化顶部工具栏
	 */
	private void initToolBar() {
		setSupportActionBar(viewHolder.tool_bar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("");
	}

	@Override
	public void onBackPressed() {

		if (viewHolder.main_drawer.isDrawerOpen(Gravity.LEFT)) {

			closeDrawer();
		} else {
			super.onBackPressed();
		}

	}

	/**
	 * 当天气加载完成时的回调
	 *
	 * @param weatherEvent
	 */
	@Subscribe
	public void onLoadWeather(WeatherEvent weatherEvent) {

		viewHolder.temp.setText(weatherEvent.getEvent().getResult().getSk().getTemp() + "℃");
		viewHolder.wind.setText(weatherEvent.getEvent().getResult().getSk().getWind_direction() + weatherEvent.getEvent().getResult().getSk().getWind_strength());
		viewHolder.humidity.setText(weatherEvent.getEvent().getResult().getSk().getHumidity());
		String weather = weatherEvent.getEvent().getResult().getToday().getWeather();
		LogUtils.i("weather:" + weather);
		int weatherId = R.drawable.weather_sun;
		if (weather.contains("雨夹雪")) {
			weatherId = R.drawable.weather_rain_and_snow;
		} else if (weather.contains("雷阵雨")) {
			weatherId = R.drawable.weather_thunder_rain;
		} else if (weather.contains("霾")) {
			weatherId = R.drawable.weather_hazes;
		} else if (weather.contains("雾")) {
			weatherId = R.drawable.weather_fog;
		} else if (weather.contains("雪")) {
			weatherId = R.drawable.weather_snow;
		} else if (weather.contains("大雨")) {
			weatherId = R.drawable.weather_large_rain;
		} else if (weather.contains("雨")) {
			weatherId = R.drawable.weather_rain;
		} else if (weather.contains("中雨")) {
			weatherId = R.drawable.weather_middle_rain;
		} else if (weather.contains("云")) {
			weatherId = R.drawable.weather_cloud;
		}else if (weather.contains("晴")){
			weatherId = R.drawable.weather_sun;
		}
		Bitmap weatherPic = ImageCache.getCache(weatherId);
		viewHolder.weather_pic.setBackgroundDrawable(new BitmapDrawable(weatherPic));
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		LogUtils.i("onNavigationItemSelected:" + item.getTitle());
		switch (item.getItemId()) {
			case R.id.collections:
				gotoSubActivity(CollectActivity.class, false);
				//closeDrawer();
				break;
			case R.id.settings:
				//gotoSubActivity(SettingsActivity.class,false);
				startActivity(new Intent(this, SettingsActivity.class));
				break;
			case R.id.history:
				gotoSubActivity(HistoryActivity.class, false);
				break;
			case R.id.logout:
				AppCache.exitApp();
				break;

		}
		return true;
	}

	private void closeDrawer() {
		viewHolder.main_drawer.closeDrawer(Gravity.LEFT);
	}
}
