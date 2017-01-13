package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 Created by handlecar on 2017/1/13.
 */

public class UCTitleBehavior extends CoordinatorLayout.Behavior<LinearLayout> {

	public UCTitleBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
		String tag = (String) dependency.getTag();
		//依赖于 NestScrollView
		return "nsv_content".equals(tag);
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {


		return true;
	}




	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View directTargetChild, View target, int
			nestedScrollAxes) {
		return directTargetChild instanceof NestedScrollView;
	}

	@Override
	public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View target, int dx, int dy, int[] consumed) {

		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
	}

	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View target, int dxConsumed, int dyConsumed, int
			dxUnconsumed, int dyUnconsumed) {
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
	}

	@Override
	public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View target) {
		super.onStopNestedScroll(coordinatorLayout, child, target);
	}

	@Override
	public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, LinearLayout child, View target, float velocityX, float
			velocityY) {
		return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
	}

	@Override
	public boolean onNestedFling(CoordinatorLayout coordinatorLayout, LinearLayout child, View target, float velocityX, float velocityY,
	                             boolean consumed) {
		return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
	}
}
