package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 Created by handlecar on 2017/1/13.
 */

public class TypeBehavior extends CoordinatorLayout.Behavior {

	public TypeBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
		return super.layoutDependsOn(parent, child, dependency);
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
		//
		return super.onDependentViewChanged(parent, child, dependency);
	}
}
