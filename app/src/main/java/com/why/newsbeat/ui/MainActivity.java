package com.why.newsbeat.ui;


import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.why.base.cache.AppCache;
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
import com.why.newsbeat.ui.junshi.JunShiFragment;
import com.why.newsbeat.ui.keji.KeJiFragment;
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
			"头条","社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"
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
		viewHolder.view_pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),mFragments,tabTitles));
		viewHolder.tab_bar.setupWithViewPager(viewHolder.view_pager);

	}

	/**
	 * 初始化侧滑布局
	 */
	private void initDrawer() {
		ActionBarDrawerToggle drawerToggle
				= new ActionBarDrawerToggle(this, viewHolder.main_drawer, viewHolder.tool_bar, R.string.open_drawer, R.string.close_drawer){
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
		NewsBeat.loadWeather();
		viewHolder.navigation_view.setItemIconTintList(null);
		NavigationMenuView navigationMenuView = (NavigationMenuView) viewHolder.navigation_view.getChildAt(0);
		if (navigationMenuView != null) {
			navigationMenuView.setVerticalScrollBarEnabled(false);
			navigationMenuView.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		}
		viewHolder.navigation_view.setNavigationItemSelectedListener(this);
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
		}else{
			super.onBackPressed();
		}

	}

	/**
	 * 当天气加载完成时的回调
	 * @param weatherEvent
	 */
	@Subscribe
	public void onLoadWeather(WeatherEvent weatherEvent){

		LogUtils.i(new Gson().toJson(weatherEvent.getEvent()));
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		LogUtils.i("onNavigationItemSelected:"+item.getTitle());
		switch (item.getItemId()){
			case R.id.collections:
				gotoSubActivity(CollectActivity.class,false);
				//closeDrawer();
				break;
			case R.id.settings:

				break;
			case R.id.history:

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
