package com.why.newsbeat.base;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.utils.DeviceConfig;
import com.why.newsbeat.base.caijing.api.CaiJingApi;
import com.why.newsbeat.base.caijing.api.CaiJingImpl;
import com.why.newsbeat.base.guoji.api.GuoJiApi;
import com.why.newsbeat.base.guoji.api.GuoJiImpl;
import com.why.newsbeat.base.guonei.api.GuoNeiApi;
import com.why.newsbeat.base.guonei.api.GuoNeiImpl;
import com.why.newsbeat.base.junshi.api.JunShiApi;
import com.why.newsbeat.base.junshi.api.JunShiImpl;
import com.why.newsbeat.base.keji.api.KeJiApi;
import com.why.newsbeat.base.keji.api.KeJiImpl;
import com.why.newsbeat.base.shehui.api.SheHuiApi;
import com.why.newsbeat.base.shehui.api.SheHuiImpl;
import com.why.newsbeat.base.shishang.api.ShiShangApi;
import com.why.newsbeat.base.shishang.api.ShiShangImpl;
import com.why.newsbeat.base.tiyu.api.TiYuApi;
import com.why.newsbeat.base.tiyu.api.TiYuImpl;
import com.why.newsbeat.base.top.api.TopApi;
import com.why.newsbeat.base.top.api.TopImpl;
import com.why.newsbeat.base.weather.api.WeatherApi;
import com.why.newsbeat.base.weather.api.WeatherImpl;
import com.why.newsbeat.base.yule.api.YuLeApi;
import com.why.newsbeat.base.yule.api.YuLeImpl;
import com.why.newsbeat.service.collect.manager.DBManager;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by lenovo on 2017/9/2.
 */

public class NewsBeat{

	private TopApi mTopImpl;
	private SheHuiApi mSheHuiImpl;
	private CaiJingApi mCaiJingImpl;
	private GuoNeiApi mGuoNeiImpl;
	private GuoJiApi mGuoJiImpl;
	private JunShiApi mJunShiImpl;
	private KeJiApi mKeJiImpl;
	private ShiShangApi mShiShangImpl;
	private TiYuApi mTiYuImpl;
	private YuLeApi mYuLeImpl;
	private WeatherApi mWeatherImpl;

	private NewsBeat(){

	}

	private static class SingleHolder{
		private static final NewsBeat mNewsBeat = new NewsBeat();
	}

	private static NewsBeat getInstance(){
		return SingleHolder.mNewsBeat;
	}

	public static void init(Context context){
		getInstance().onInit(context);
	}

	private void onInit(Context context) {
		initBugly(context);
		initUmengShare();
		initGreenDao(context);


	}

	/**
	 * 对数据库进行初始化
	 *
	 * @param context
	 */
	private void initGreenDao(Context context) {

		DBManager.init(context);
	}

	/**
	 * 初始化友盟分享组件
	 */
	private void initUmengShare() {
		PlatformConfig.setWeixin("4155444921","a8d7372b73d6d5dae7a9e90f43fc8115");
		PlatformConfig.setQQZone("1106338049","7NVp0yRpmGavdBB6");
		PlatformConfig.setSinaWeibo("4155444921","a8d7372b73d6d5dae7a9e90f43fc8115","");
	}

	/**
	 * 对bugly配置
	 * 
	 * @param context
	 */
	private void initBugly(final Context context) {
		//bug上传,(包括x5内核错误)
		CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
		strategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() {
			public Map onCrashHandleStart(int crashType, String errorType, String errorMessage, String errorStack) {
				LinkedHashMap map = new LinkedHashMap();
				String x5CrashInfo = com.tencent.smtt.sdk.WebView.getCrashExtraMessage(context);
				map.put("x5crashInfo", x5CrashInfo);
				return map;
			}
			@Override
			public byte[] onCrashHandleStart2GetExtraDatas(int crashType, String errorType, String errorMessage, String errorStack) {
				try {
					return "Extra data.".getBytes("UTF-8");
				} catch (Exception e) {
					return null;
				}
			}
		});
		CrashReport.initCrashReport(context, "de96a4996c", true,strategy);
	}

	public static void loadTopNews(){
		getInstance().getTopImpl().loadATopNews();
	}
	private TopApi getTopImpl(){
		if (mTopImpl==null){
			synchronized (NewsBeat.class){
				if (mTopImpl==null){
					mTopImpl = new TopImpl();
				}
			}
		}
		return mTopImpl;
	}


	public static void loadSheHuiNews() {
		getInstance().getSheHuiImpl().loadSheHuiNews();
	}

	private SheHuiApi getSheHuiImpl() {
		if (mSheHuiImpl==null){
			synchronized (NewsBeat.class){
				if (mSheHuiImpl==null){
					mSheHuiImpl = new SheHuiImpl();
				}
			}
		}
		return mSheHuiImpl;
	}

	public static void loadCaiJingNews() {
		getInstance().getCaiJingImpl().loadCaiJingNews();
	}
	private CaiJingApi getCaiJingImpl() {
		if (mCaiJingImpl==null){
			synchronized (NewsBeat.class){
				if (mCaiJingImpl==null){
					mCaiJingImpl = new CaiJingImpl();
				}
			}
		}
		return mCaiJingImpl;
	}
	public static void loadGuoNeiNews() {
		getInstance().getGuoNeiImpl().loadGuoNeiNews();
	}
	private GuoNeiApi getGuoNeiImpl() {
		if (mGuoNeiImpl==null){
			synchronized (NewsBeat.class){
				if (mGuoNeiImpl==null){
					mGuoNeiImpl = new GuoNeiImpl();
				}
			}
		}
		return mGuoNeiImpl;
	}
	public static void loadGuoJiNews() {
		getInstance().getGuoJiImpl().loadGuoJiNews();
	}
	private GuoJiApi getGuoJiImpl() {
		if (mGuoJiImpl==null){
			synchronized (NewsBeat.class){
				if (mGuoJiImpl==null){
					mGuoJiImpl = new GuoJiImpl();
				}
			}
		}
		return mGuoJiImpl;
	}
	public static void loadJunShiNews() {
		getInstance().getJunShiImpl().loadJunShiNews();
	}
	private JunShiApi getJunShiImpl() {
		if (mJunShiImpl==null){
			synchronized (NewsBeat.class){
				if (mJunShiImpl==null){
					mJunShiImpl = new JunShiImpl();
				}
			}
		}
		return mJunShiImpl;
	}
	public static void loadKeJiNews() {
		getInstance().getKeJiImpl().loadKeJiNews();
	}
	private KeJiApi getKeJiImpl() {
		if (mKeJiImpl==null){
			synchronized (NewsBeat.class){
				if (mKeJiImpl==null){
					mKeJiImpl = new KeJiImpl();
				}
			}
		}
		return mKeJiImpl;
	}
	public static void loadShiShangNews() {
		getInstance().getShiShangImpl().loadShiShangNews();
	}
	private ShiShangApi getShiShangImpl() {
		if (mShiShangImpl==null){
			synchronized (NewsBeat.class){
				if (mShiShangImpl==null){
					mShiShangImpl = new ShiShangImpl();
				}
			}
		}
		return mShiShangImpl;
	}
	public static void loadTiYuNews() {
		getInstance().getTiYuImpl().loadTiYuNews();
	}
	private TiYuApi getTiYuImpl() {
		if (mTiYuImpl==null){
			synchronized (NewsBeat.class){
				if (mTiYuImpl==null){
					mTiYuImpl = new TiYuImpl();
				}
			}
		}
		return mTiYuImpl;
	}
	public static void loadYuLeNews() {
		getInstance().getYuLeImpl().loadYuLeNews();
	}
	private YuLeApi getYuLeImpl() {
		if (mYuLeImpl==null){
			synchronized (NewsBeat.class){
				if (mYuLeImpl==null){
					mYuLeImpl = new YuLeImpl();
				}
			}
		}
		return mYuLeImpl;
	}


	private WeatherApi getWeatherImpl(){
		if (mWeatherImpl ==null){

			synchronized (NewsBeat.class){
				if (mWeatherImpl==null){
					mWeatherImpl = new WeatherImpl();
				}
			}
		}

		return mWeatherImpl;
	}

	public static void loadWeather(){
		getInstance().getWeatherImpl().loadWeather();
	}

}
