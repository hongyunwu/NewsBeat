package com.why.newsbeat.ui.detail;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.why.base.ui.BaseActivity;
import com.why.base.utils.LogUtils;
import com.why.newsbeat.R;
import com.why.newsbeat.base.NewsBeat;
import com.why.newsbeat.base.detail.DetailApi;
import com.why.newsbeat.base.collect.bean.Collect;
import com.why.newsbeat.base.history.bean.History;
import com.why.newsbeat.dao.manager.DBManager;
import com.why.newsbeat.ui.detail.comments.CommentsFragment;

public class NewsDetailActivity extends BaseActivity<NewsDetailViewHolder> implements View.OnClickListener {


	private DetailApi detailApi;
	private UMShareListener umShareListener = new UMShareListener() {
		@Override
		public void onStart(SHARE_MEDIA share_media) {
			LogUtils.i("onStart->" + share_media);
		}

		@Override
		public void onResult(SHARE_MEDIA share_media) {
			LogUtils.i("onResult->" + share_media);
		}

		@Override
		public void onError(SHARE_MEDIA share_media, Throwable throwable) {
			LogUtils.i("onError->" + share_media + ",error->" + throwable.getMessage());
		}

		@Override
		public void onCancel(SHARE_MEDIA share_media) {
			LogUtils.i("onCancel->" + share_media);
		}
	};

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
		viewHolder.author_name.setText(detailApi.getAuthor_name());
		viewHolder.date.setText(detailApi.getDate());

		DBManager.insert(getApplicationContext(),new History(NewsBeat.getUserName(),
				detailApi.getUniquekey(),
				detailApi.getTitle(),
				detailApi.getDate(),
				detailApi.getCategory(),
				detailApi.getAuthor_name(),
				detailApi.getUrl(),
				detailApi.getThumbnail_pic_s(),
				detailApi.getThumbnail_pic_s02(),
				detailApi.getThumbnail_pic_s03(),
				SystemClock.uptimeMillis()));
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

				switch (item.getItemId()) {
					case R.id.share:
						LogUtils.i("onMenuItemClick->share");
						//UMShareAPI.get(NewsDetailActivity.this).getPlatformInfo(this, S, authListener);
						new ShareAction(NewsDetailActivity.this)
								.withText("hello")
								.setDisplayList(SHARE_MEDIA.SINA
										, SHARE_MEDIA.QQ
										, SHARE_MEDIA.WEIXIN
										, SHARE_MEDIA.WEIXIN_CIRCLE
										, SHARE_MEDIA.WEIXIN_FAVORITE
								)
								.setCallback(umShareListener)
								.open();
						break;
					case R.id.collect:
						LogUtils.i("onMenuItemClick->item.isChecked():" + item.isChecked());
						if (item.isChecked()) {

							DBManager.delete(getApplication(), new Collect(SystemClock.uptimeMillis()
									,NewsBeat.getUserName()
									, detailApi.getUniquekey()
									, detailApi.getTitle()
									, detailApi.getDate()
									, detailApi.getCategory()
									, detailApi.getAuthor_name()
									, detailApi.getUrl()
									, detailApi.getThumbnail_pic_s()
									, detailApi.getThumbnail_pic_s02()
									, detailApi.getThumbnail_pic_s03()
									));
							viewHolder.comments_bar.getMenu().findItem(R.id.collect).setIcon(R.drawable.collect_unselected);

						} else {
							DBManager.insert(getApplication(), new Collect(SystemClock.uptimeMillis()
									,NewsBeat.getUserName()
									, detailApi.getUniquekey()
									, detailApi.getTitle()
									, detailApi.getDate()
									, detailApi.getCategory()
									, detailApi.getAuthor_name()
									, detailApi.getUrl()
									, detailApi.getThumbnail_pic_s()
									, detailApi.getThumbnail_pic_s02()
									, detailApi.getThumbnail_pic_s03()));
							viewHolder.comments_bar.getMenu().findItem(R.id.collect).setIcon(R.drawable.collect_selected);

						}
						item.setChecked(!item.isChecked());

						break;
					case R.id.message:
						LogUtils.i("onMenuItemClick->message");
						break;
				}
				return true;
			}
		});
		viewHolder.write_comments.setOnClickListener(this);
		int size = DBManager.queryCollect(getApplication(), detailApi.getUniquekey(), NewsBeat.getUserName()).size();
		//数据库查询是否已经被收藏
		if(size>0){
			viewHolder.comments_bar.getMenu().findItem(R.id.collect).setIcon(R.drawable.collect_selected);
			viewHolder.comments_bar.getMenu().findItem(R.id.collect).setChecked(true);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
	}

	private void initWebView() {
		viewHolder.news_detail.getSettings().setJavaScriptEnabled(true);
		viewHolder.news_detail.loadUrl(detailApi.getUrl());
		viewHolder.news_detail.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView webView, String url) {
				viewHolder.news_detail.loadUrl(url);
				return true;
			}
		});
		viewHolder.news_detail.setWebChromeClient(new WebChromeClient() {


			@Override
			public void onProgressChanged(WebView webView, int progress) {
				if (progress == 100) {
					viewHolder.progress.setVisibility(View.INVISIBLE);
				} else {
					viewHolder.progress.setProgress(progress);
				}

				LogUtils.i("onProgressChanged:" + progress);
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
		if (viewHolder.news_detail.canGoBack()) {
			viewHolder.news_detail.goBack();
		} else {
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
		UMShareAPI.get(this).release();
		super.onDestroy();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.write_comments:
				LogUtils.i("onClick->write_comments");
				new CommentsFragment().show(getSupportFragmentManager(), "");
				break;

			default:
				break;
		}
	}
}
