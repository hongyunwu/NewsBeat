package com.why.newsbeat.ui.detail;

import android.view.View;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.why.base.ui.BaseActivity;
import com.why.base.utils.LogUtils;
import com.why.newsbeat.R;

public class NewsDetailActivity extends BaseActivity<NewsDetailViewHolder> {


	private String url;

	@Override
	public int getLayoutID() {
		return R.layout.activity_news_detail;
	}

	@Override
	protected void dealIntent() {

		url = getIntent().getExtras().getString("news");
	}

	@Override
	public void initData() {
		viewHolder.news_detail.getSettings().setJavaScriptEnabled(true);
		viewHolder.news_detail.loadUrl(url);
		viewHolder.news_detail.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView webView, String url) {
				viewHolder.news_detail.loadUrl(url);
				return true;
			}
		});
		viewHolder.news_detail.setWebChromeClient(new WebChromeClient(){


			@Override
			public void onProgressChanged(WebView webView, int progress) {
				if (progress==100){
					viewHolder.progress.setVisibility(View.GONE);
				}else {
					viewHolder.progress.setProgress(progress);
				}

				LogUtils.i("onProgressChanged:"+progress);
				super.onProgressChanged(webView, progress);
			}
		});
	}

	@Override
	public void onBackPressed() {
		if (viewHolder.news_detail.canGoBack()){
			viewHolder.news_detail.goBack();
		}else {
			super.onBackPressed();
		}

	}

	@Override
	protected void onPause() {
		super.onPause();
		viewHolder.news_detail.onPause();
		viewHolder.news_detail.pauseTimers();
	}

	@Override
	protected void onResume() {
		super.onResume();
		viewHolder.news_detail.resumeTimers();
		viewHolder.news_detail.onResume();

	}

	@Override
	protected void onDestroy() {
		viewHolder.news_detail.destroy();
		super.onDestroy();

	}
}
