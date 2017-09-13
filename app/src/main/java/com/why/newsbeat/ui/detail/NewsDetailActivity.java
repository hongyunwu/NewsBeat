package com.why.newsbeat.ui.detail;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.why.base.ui.BaseActivity;
import com.why.base.utils.LogUtils;
import com.why.newsbeat.R;
import com.why.newsbeat.base.detail.DetailApi;

public class NewsDetailActivity extends BaseActivity<NewsDetailViewHolder> implements View.OnClickListener {


	private DetailApi detailApi;

	@Override
	public int getLayoutID() {
		return R.layout.activity_news_detail;
	}

	@Override
	public int getMenuId() {
		return R.menu.menu;
	}

	@Override
	protected void dealIntent() {

		detailApi = getIntent().getParcelableExtra("news");
	}

	@Override
	public void initData() {
		initToolBar();
		initCommentsBar();
		initWebView();
	}

	/**
	 * 对评论栏进行初始化
	 */
	private void initCommentsBar() {
		viewHolder.comments_bar.inflateMenu(R.menu.comments_menu);
		viewHolder.comments_bar.setNavigationIcon(R.drawable.back);
		viewHolder.comments_bar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		viewHolder.comments_bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {

				switch (item.getItemId()){
					case R.id.share:
						LogUtils.i("onMenuItemClick->share");
						break;
					case R.id.collect:
						LogUtils.i("onMenuItemClick->collect");
						break;
					case R.id.message:
						LogUtils.i("onMenuItemClick->message");
						break;
				}
				return true;
			}
		});
		viewHolder.write_comments.setOnClickListener(this);
	}

	private void initWebView() {
		viewHolder.news_detail.getSettings().setJavaScriptEnabled(true);
		viewHolder.news_detail.loadUrl(detailApi.getUrl());
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
					viewHolder.progress.setVisibility(View.INVISIBLE);
				}else {
					viewHolder.progress.setProgress(progress);
				}

				LogUtils.i("onProgressChanged:"+progress);
				super.onProgressChanged(webView, progress);
			}
		});
	}

	private void initToolBar() {

		setSupportActionBar(viewHolder.tool_bar);
		getSupportActionBar().setTitle("");
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

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.write_comments:
				LogUtils.i("onClick->write_comments");
				new CommentsFragment().show(getSupportFragmentManager(),"");
				break;

			default:
				break;
		}
	}
}
