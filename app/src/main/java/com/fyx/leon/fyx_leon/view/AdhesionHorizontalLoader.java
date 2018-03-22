package com.fyx.leon.fyx_leon.view;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
public class AdhesionHorizontalLoader extends View {
    /**
     * 宽度
     */
    private int mWidth;

    /**
     * 高度
     */
    private int mHeight;

    /**
     * 当前的静态圆半径
     */
    private float mCurrentStaticCircleRadius = 50f;

    /**
     * 静态圆变化半径的最大比率
     */
    private float mMaxStaticCircleRadiusScaleRate = 0.2f;
    /**
     * 最大粘连长度
     */
    private float mMaxAdherentLength = 3.5f * mCurrentStaticCircleRadius;
    /**
     * 静态圆
     */
    private Circle mStaticCircle;
    /**
     * 动态圆
     */
    private Circle mDynamicCircle;
    /**
     * 画笔
     */
    private Paint mPaint = new Paint();
    /**
     * 路径
     */
    private Path mPath = new Path();

    /**
     * 默认颜色
     */
    private int mColor = 0xFF4DB9FF;

    /**
     * 构造函数
     *
     * @param context
     */
    public AdhesionHorizontalLoader(Context context) {
        super(context);
        init();
    }

    /**
     * 构造函数
     *
     * @param context
     * @param attrs
     */
    public AdhesionHorizontalLoader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 构造函数
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public AdhesionHorizontalLoader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {

        // 画笔
        mPath.reset();
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        // 宽度、高度
        mWidth = (int) ((mCurrentStaticCircleRadius * 5) * 3);
        mHeight = 200;

        //动态圆
        mDynamicCircle = new Circle();
        mDynamicCircle.radius = mCurrentStaticCircleRadius / 2;
        mDynamicCircle.x = mDynamicCircle.radius;
        mDynamicCircle.y = mHeight / 2;

        // 静态圆
        mStaticCircle = new Circle();
        mStaticCircle.radius = mCurrentStaticCircleRadius;
        mStaticCircle.x = 0;
        mStaticCircle.y = mHeight / 2;
    }

    /**
     * 测量尺寸
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec 知识补充：
     *                          方法resolveSizeAndState()
     *                          用来创建最终的宽和高. 这个方法通过比较视图的期望大小返回一个合适的View.MeasureSpec值传入onMeasure()
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(resolveSizeAndState(mWidth, widthMeasureSpec, MeasureSpec.UNSPECIFIED), resolveSizeAndState(mHeight, heightMeasureSpec, MeasureSpec.UNSPECIFIED));
    }

    /**
     * 绘制视图
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //动态圆
        canvas.drawCircle(mDynamicCircle.x, mDynamicCircle.y, mDynamicCircle.radius, mPaint);
        // 静态圆
        canvas.drawCircle(mStaticCircle.x, mStaticCircle.y, mCurrentStaticCircleRadius, mPaint);
        //变化
        float distance = (float) Math.sqrt(Math.pow(mDynamicCircle.x - mStaticCircle.x, 2) + Math.pow(mDynamicCircle.y - mStaticCircle.y, 2));
        float scale = mMaxStaticCircleRadiusScaleRate - mMaxStaticCircleRadiusScaleRate * (distance / mMaxAdherentLength);
        mCurrentStaticCircleRadius = mStaticCircle.radius * (1 + scale);
        //判断是否使用贝塞尔
        if (distance < mMaxAdherentLength) {
            mPath = Adhesion.drawAdhesionBody(mStaticCircle.x, mStaticCircle.y,
                    mCurrentStaticCircleRadius, 45, mDynamicCircle.x, mDynamicCircle.y, mDynamicCircle.radius, 45);
            canvas.drawPath(mPath, mPaint);

        } else {
            canvas.drawCircle(mStaticCircle.x, mStaticCircle.y, mStaticCircle.radius, mPaint);
            mPath.reset();
        }
    }

    /**
     * 开始动画
     */
    public void startAnim() {
         /* x方向 */

        ValueAnimator xValueAnimator = ValueAnimator.ofFloat( 0, mWidth - mDynamicCircle.radius,1f,0f);
        xValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        xValueAnimator.setDuration(3000);
        xValueAnimator.start();
        xValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDynamicCircle.x = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

    }

    public void setColor(int color) {
        mColor = color;
        mPaint.setColor(mColor);
    }

    /**
     * 圆类
     */
    private class Circle {
        public float x;
        public float y;
        public float radius;
    }


}
