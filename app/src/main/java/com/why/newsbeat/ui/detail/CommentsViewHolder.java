package com.why.newsbeat.ui.detail;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.why.base.ui.BaseHolder;
import com.why.newsbeat.R;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/9/13.
 */
public class CommentsViewHolder extends BaseHolder {

	@BindView(R.id.send_comments)
	Button send_comments;
	@BindView(R.id.comments_content)
	EditText comments_content;
	/**
	 * 此处使用butterKnife进行了view绑定操作
	 *
	 * @param itemView
	 */
	public CommentsViewHolder(View itemView) {
		super(itemView);
	}
}
