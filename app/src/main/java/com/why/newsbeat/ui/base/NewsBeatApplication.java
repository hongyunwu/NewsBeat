package com.why.newsbeat.ui.base;

import com.tencent.bugly.crashreport.CrashReport;
import com.why.base.BaseApplication;
import com.why.newsbeat.base.NewsBeat;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/9/3.
 */

public class NewsBeatApplication extends BaseApplication {
	@Override
	public void onCreate() {
		super.onCreate();

		NewsBeat.init(getApplicationContext());

	}
}
