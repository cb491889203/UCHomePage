package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 Created by handlecar on 2017/1/12.
 */

public class MyNestScrollviewBehavior extends CoordinatorLayout.Behavior {

	private static final String TAG = "MyNestScrollviewBehavio";
	Context context;

	public MyNestScrollviewBehavior() {
	}

	public MyNestScrollviewBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int
			nestedScrollAxes) {
		if (directTargetChild instanceof NestedScrollView) {
			Log.i(TAG, "onStartNestedScroll: ===== true");
			return true;
		}

		Log.i(TAG, "onStartNestedScroll:   ===== false");
		return false;
	}


	@Override
	public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
		Log.i(TAG, "onNestedPreScroll: --------");
		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
	}
	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int
			dxUnconsumed, int dyUnconsumed) {
		Log.i(TAG, "onNestedScroll: ---------");
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
	}

	@Override
	public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
		Log.i(TAG, "onNestedPreFling: ----------");
		return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
	}

	@Override
	public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean
			consumed) {
		Log.i(TAG, "onNestedFling: -----------");
		return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
	}

	@Override
	public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
		Log.i(TAG, "onStopNestedScroll: --------");
		super.onStopNestedScroll(coordinatorLayout, child, target);
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
		Log.i(TAG, "onDependentViewChanged: ---------");
		return super.onDependentViewChanged(parent, child, dependency);
	}

}
