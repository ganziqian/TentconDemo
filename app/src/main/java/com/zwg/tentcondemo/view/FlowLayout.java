package com.zwg.tentcondemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人： ganziqian
 * 时  间： 2017/7/29.
 * 作  用：
 */

public class FlowLayout extends ViewGroup{

    /**
     * 保存每行view的列表
     */
    private List<List<View>> mViewLinesList=new ArrayList<>();

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int iwidthMode=MeasureSpec.getMode(widthMeasureSpec);
        int iheigthMode=MeasureSpec.getMode(heightMeasureSpec);

        int iwidthSpec=MeasureSpec.getSize(widthMeasureSpec);
        int iheigthSpec=MeasureSpec.getSize(heightMeasureSpec);

        int measuredWith=0;
        int measuredHeight=0;

        int iCurLineW=0;
        int iCureLindH=0;

        if(iheigthMode!=MeasureSpec.EXACTLY&&iwidthMode!=MeasureSpec.EXACTLY){
            measuredWith=iwidthSpec;
            measuredHeight=iheigthSpec;
        }else {
            int iChildWidth;
            int iChildHeight;


            int childCount=getChildCount();
            for(int i=0;i<childCount;i++){
                View childView=getChildAt(i);
                measureChild(childView,widthMeasureSpec,heightMeasureSpec);
                MarginLayoutParams layoutParams= (MarginLayoutParams) childView.getLayoutParams();
                iChildWidth=childView.getMeasuredWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
                iChildHeight=childView.getHeight()+layoutParams.topMargin+layoutParams.bottomMargin;

                if(iCurLineW+iChildWidth>iwidthSpec){

                    //换行,记录新的一行信息
                    measuredWith=Math.max(measuredHeight,iCurLineW);
                    measuredHeight+=iCureLindH;

                    //重新赋值新一行的宽高
                    iCurLineW=iChildWidth;
                    iCureLindH=iChildHeight;


                }else {
                    //记录某行内的信息
                    iCurLineW+=iChildWidth;
                    iChildHeight=Math.max(iCureLindH,iChildHeight);

                }

            }

        }

        //最终目的
        setMeasuredDimension(measuredWith,measuredHeight);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
