package com.why.newsbeat.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.why.base.ui.BaseFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/3.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

	private String[] mTitles;
	private ArrayList<BaseFragment> mFragments;

	public MainPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments,String[] titles) {
		super(fm);
		this.mFragments = fragments;
		this.mTitles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		if (mFragments!=null){
			return mFragments.size();
		}
		return 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mTitles[position];
	}
}
