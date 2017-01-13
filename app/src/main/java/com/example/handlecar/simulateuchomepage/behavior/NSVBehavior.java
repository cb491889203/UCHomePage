package com.example.handlecar.simulateuchomepage.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 Created by handlecar on 2017/1/13.
 */

public class NSVBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {

	/** 当前到控件正在滚动 */
	private boolean isDrag;

	public NSVBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, NestedScrollView child, View dependency) {
		String tag = (String) dependency.getTag();
//		return "ll_header".equals(tag);
		return false;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, NestedScrollView child, View dependency) {
		return super.onDependentViewChanged(parent, child, dependency);
	}

	//这里我们自己测量NestedScrollView以及它的子 view。
	@Override
	public boolean onMeasureChild(CoordinatorLayout parent, NestedScrollView child, int parentWidthMeasureSpec, int widthUsed, int
			parentHeightMeasureSpec, int heightUsed) {

		//以下代码是复制AppBarLayout中实现当Behavior的逻辑
		//当嵌套滚动时，需要根据嵌套滚动当距离来测量
		final CoordinatorLayout.LayoutParams lp =
				(CoordinatorLayout.LayoutParams) child.getLayoutParams();
		if (lp.height == CoordinatorLayout.LayoutParams.WRAP_CONTENT) {
			// If the view is set to wrap on it's height, CoordinatorLayout by default will
			// cap the view at the CoL's height. Since the AppBarLayout can scroll, this isn't
			// what we actually want, so we measure it ourselves with an unspecified spec to
			// allow the child to be larger than it's parent
			parent.onMeasureChild(child, parentWidthMeasureSpec, widthUsed,
					View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), heightUsed);
			return true;
		}

		//当没在嵌套滚动时，使用系统默认当方式来测量
		// Let the parent handle it as normal
		return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed,
				parentHeightMeasureSpec, heightUsed);
	}

	//这里我们自己布局NestedScrollView以及它的子 view。
	@Override
	public boolean onLayoutChild(CoordinatorLayout parent, NestedScrollView child, int layoutDirection) {

		return super.onLayoutChild(parent, child, layoutDirection);
	}

	//在开始滚动的时候，coordinatorlayout会遍历所有的子 view，询问是否需要嵌套滚动，其中我们自己也会被询问到，
	// 所以，这里我们自己再来接受事件，根据滚动动态变化大小。
	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View directTargetChild, View target,
	                                   int nestedScrollAxes) {
		//当scrollview还没到顶部时，由我们接管消费滑动，让他先滚动到顶部，此时标记为isdrag。 如果到了顶部，才让他执行自己到滚动。
		return true;
	}

	@Override
	public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, NestedScrollView child, View directTargetChild, View target,
	                                   int nestedScrollAxes) {
		//标记当前是在滚动
		isDrag = true;
	}

	@Override
	public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, int dx, int dy, int[]
			consumed) {
		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
	}

	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, int dxConsumed, int dyConsumed,
	                           int dxUnconsumed, int dyUnconsumed) {
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
	}

	@Override
	public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, float velocityX, float
			velocityY) {
		return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
	}

	//快速滑动
	@Override
	public boolean onNestedFling(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, float velocityX, float
			velocityY, boolean consumed) {
		//当scrollview还没到顶部时，由我们接管消费滑动，让他先滚动到顶部。 如果到了顶部，才让他执行自己到滚动。
		return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
	}

	//不管是 普通的scroll ，还是快速fling， onstopnestedscroll都会在滑动最后结束来才被调用，所以可以最后放心使用
	@Override
	public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target) {
		isDrag = false;
	}

}
