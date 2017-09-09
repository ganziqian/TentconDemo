package com.zwg.tentcondemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 创建人： ganziqian
 * 时  间： 2017/7/28.
 * 作  用：
 */

public class ScrollZoomListview extends ListView{
    private int imageHeight;
    private ImageView iv;

    public ScrollZoomListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        //imageHeight=160;
        imageHeight= context.getResources().getDimensionPixelSize(R.dimen.defautheigh);
    }
    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
       //下拉过度回调监听  deltaY
        /**
         * 两种情况
         * dy: -往下拉过度
         * dy:+往上拉过度
         */

        if(deltaY<0){  //下拉过度
            //iamgeview放大效果 ---修改imageview高度加android:scaleType="centerCrop"

            iv.getLayoutParams().height=iv.getHeight()-deltaY;
            iv.requestLayout();
        }else {
            iv.getLayoutParams().height=deltaY-iv.getHeight();
            iv.requestLayout();
        }

        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        //往上推，图片缩小
        View hear= (View) iv.getParent();
        int deltaY=hear.getTop();
        //只有imageview被放大过才会执行缩小
        if(iv.getHeight()>imageHeight) {
            iv.getLayoutParams().height = iv.getHeight() + deltaY;

            //由于滑出去了，所以要ranghead父容器重新摆放top
            hear.layout(hear.getLeft(),0,hear.getRight(),hear.getHeight());
            iv.requestLayout();
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        if(action==MotionEvent.ACTION_UP){
            ResetAnimation resetAnimation=new ResetAnimation();
            resetAnimation.setDuration(600);
            iv.startAnimation(resetAnimation);
        }

        return super.onTouchEvent(ev);
    }

    public  class ResetAnimation extends Animation{

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {

            iv.getLayoutParams().height=iv.getHeight()-(iv.getHeight()-imageHeight);
            iv.requestLayout();

            super.applyTransformation(interpolatedTime, t);
        }
    }
}
