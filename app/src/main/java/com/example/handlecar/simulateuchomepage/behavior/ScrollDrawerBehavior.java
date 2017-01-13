package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 Created by handlecar on 2017/1/13.
 */

public class ScrollDrawerBehavior extends CoordinatorLayout.Behavior {

	private int startY;
	private static final String TAG = "DrawerBehavior";
	public ScrollDrawerBehavior() {
	}

	public ScrollDrawerBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {

		return child instanceof AppBarLayout;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
		if (startY == 0) {
			startY = dependency.getHeight();
		}
		float percent = dependency.getY() / startY;
		child.setY(child.getHeight() * (1-percent) - child.getHeight());
		return true;
	}
}
