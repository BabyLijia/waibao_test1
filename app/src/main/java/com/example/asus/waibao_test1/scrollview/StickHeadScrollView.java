package com.example.asus.waibao_test1.scrollview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

//优化嵌套滑动(可保留置顶控件)
public class StickHeadScrollView extends NestedScrollView{

    //自定义StickHeadScrollView继承NestedScrollView

    public StickHeadScrollView(@NonNull Context context) {
        super(context);
    }

    public StickHeadScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StickHeadScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void resetHeight(final View headView, final RecyclerView recyclerView) {
        this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                StickHeadScrollView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                recyclerView.getLayoutParams().height=StickHeadScrollView.this.getHeight()-headView.getHeight();
                recyclerView.requestLayout();
            }
        });
    }
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        //判断是否需要优先嵌套滑动,解决触摸recyclerview 无法关闭swiperefreshlayout的bug
        if (!dispatchNestedPreScroll(dx, dy, consumed, null)) {
            //嵌套滑动代码
            boolean hiddenTop = dy > 0 && getScrollY() < getChildAt(0).getHeight() - getHeight();
            boolean showTop = dy < 0 && getScrollY() > 0 && !ViewCompat.canScrollVertically(target, -1);

            if (hiddenTop || showTop) {
                scrollBy(0, dy);
                consumed[1] = dy;
            }
        }
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        if (getScrollY() >= getChildAt(0).getHeight() - getHeight())
            return false;
        fling((int) velocityY);
        return true;
    }
}
