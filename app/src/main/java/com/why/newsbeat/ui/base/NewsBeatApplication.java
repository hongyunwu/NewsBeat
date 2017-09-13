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

	/**
	 * PlatformConfig.setWeixin("4155444921","a8d7372b73d6d5dae7a9e90f43fc8115");
	 PlatformConfig.setQQZone("1106338049","7NVp0yRpmGavdBB6");
	 PlatformConfig.setSinaWeibo("4155444921","a8d7372b73d6d5dae7a9e90f43fc8115","");
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		NewsBeat.init(getApplicationContext());

	}
}
