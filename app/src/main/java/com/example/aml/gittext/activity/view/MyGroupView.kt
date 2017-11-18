package com.example.aml.gittext.activity.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.support.v4.widget.ViewDragHelper
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout


/**
 * Created by 18624915319 on 2017/11/16.
 **/
open class MyGroupView : RelativeLayout {

    private lateinit var mDragHelper: ViewDragHelper
    private lateinit var menu: View
    private lateinit var content: View
    private var showPer: Int = 80
    private var currentLeft: Int = -1
    private val parentSize = object {
        var width = 0
        var height = 0
    }
    private val menuSize = parentSize

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mDragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {

            //是否捕捉视图
            override fun tryCaptureView(child: View?, pointerId: Int): Boolean {
                child ?: return false
                return false
            }

            //水平滑动坐标
            override fun clampViewPositionHorizontal(child: View?, left: Int, dx: Int): Int {
                child ?: return super.clampViewPositionHorizontal(child, left, dx)
                //始终都是取left的值，初始值为-child.getWidth()，当向右拖动的时候left值增大，当left大于0的时候取0
                return if (left <= 0 && -menuSize.width < left) left
                else if (-menuSize.width >= left) -menuSize.width
                else 0
            }

            //View拖行结束
            override fun onViewReleased(releasedChild: View?, xvel: Float, yvel: Float) {
                releasedChild ?: return super.onViewReleased(releasedChild, xvel, yvel)
                if (Math.abs(currentLeft) > menuSize.width / 2) {
                    mDragHelper.settleCapturedViewAt(-menuSize.width, 0)
                } else {
                    mDragHelper.settleCapturedViewAt(0, 0)
                }
                postInvalidate()
            }

            //拖动坐标的变化
            override fun onViewPositionChanged(changedView: View?, left: Int, top: Int, dx: Int, dy: Int) {
                super.onViewPositionChanged(changedView, left, top, dx, dy)
                currentLeft = left
            }

            //边缘拖动
            override fun onEdgeDragStarted(edgeFlags: Int, pointerId: Int) {
                if (edgeFlags == ViewDragHelper.EDGE_LEFT)
                    mDragHelper.captureChildView(menu, pointerId)
            }

        })
        mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return super.onInterceptTouchEvent(ev)
        return mDragHelper.shouldInterceptTouchEvent(ev)
    }

    override fun computeScroll() {
        if (mDragHelper.continueSettling(true))
            invalidate()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return super.onTouchEvent(event)
        mDragHelper.processTouchEvent(event)
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        parentSize.width = MeasureSpec.getSize(widthMeasureSpec)
        parentSize.height = MeasureSpec.getSize(heightMeasureSpec)
        //重新设置菜单宽高，控制宽高
        menu.layoutParams.apply {
            width = parentSize.width * showPer / 100
            height = parentSize.height
            //组装侧滑视图的宽高
            menuSize.width = width
            menuSize.height = height
        }
        mDragHelper.smoothSlideViewTo(menu, -width, height)
    }

    //布局完成 xml 的解析
    override fun onFinishInflate() {
        super.onFinishInflate()
        //获取主视图View
        content = getChildAt(0)
        //获取菜单View
        menu = getChildAt(1)
    }

    public fun closeMenu() {
        mDragHelper.smoothSlideViewTo(menu, -menuSize.width, menuSize.height)
        currentLeft = -menuSize.width
    }

    public fun openMenu() {
        mDragHelper.smoothSlideViewTo(menu, 0, menuSize.height)
        currentLeft = 0
    }


}