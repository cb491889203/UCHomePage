package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 Created by handlecar on 2017/1/13.
 */

public class HeaderBehavior extends CoordinatorLayout.Behavior {

	public HeaderBehavior(Context context, AttributeSet attrs) {

		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
		//依赖与scrollview的变化
		String tag = (String) dependency.getTag();
		return "scv_content".equals(tag);
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
		//随着scv_content的变化，执行渐变的动画以及缩放。


		return true;
	}

}
