package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 Created by handlecar on 2017/1/13.
 */

public class DrawerBehavior extends CoordinatorLayout.Behavior {

	private int startY;
	private static final String TAG = "DrawerBehavior";
	public DrawerBehavior() {
	}

	public DrawerBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
		String tag = (String) dependency.getTag();
		if ("toolbar".equals(tag)) {
			Log.i(TAG, "layoutDependsOn: toolbar ---- true");
			return true;
		}
		Log.i(TAG, "layoutDependsOn: toolbar ----- false");
		return false;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
		if (startY == 0) {
			startY = (int) dependency.getY();
		}
		float percent = dependency.getY() / startY;
		child.setY(child.getHeight() * (1-percent) - child.getHeight());
		return true;
	}

	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int
			nestedScrollAxes) {
		return true;
	}

	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int
			dxUnconsumed, int dyUnconsumed) {

	}


}
