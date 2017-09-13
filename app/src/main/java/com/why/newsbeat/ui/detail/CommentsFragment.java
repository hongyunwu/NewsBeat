package com.why.newsbeat.ui.detail;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.WindowManager;

import com.why.base.ui.BaseDialogFragment;
import com.why.newsbeat.R;

/**
 * Created by lenovo on 2017/9/13.
 */

public class CommentsFragment extends BaseDialogFragment<CommentsViewHolder> {


	@Override
	public void onStart() {

		getDialog().getWindow().getAttributes().width = getResources().getDisplayMetrics().widthPixels;
		getDialog().getWindow().setGravity(Gravity.BOTTOM);
		getDialog().getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		super.onStart();

	}

	@Override
	public int getStyle() {

		return R.style.CommentsDialogStyle;
	}

	@Override
	protected void initData() {
		viewHolder.comments_content.setFocusableInTouchMode(true);
		viewHolder.comments_content.setFocusable(true);
		viewHolder.comments_content.requestFocus();
		viewHolder.comments_content.addTextChangedListener(new CommentsTextChangedListener() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				viewHolder.send_comments.setEnabled(!TextUtils.isEmpty(s));
			}
		});

	}

	@Override
	protected int getLayoutID() {
		return R.layout.fragment_comments_dialog;
	}



}
