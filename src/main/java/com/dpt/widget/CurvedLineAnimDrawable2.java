package com.dpt.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.*;
import android.graphics.drawable.Drawable;

/**
 * Created by dupengtao on 14-9-11.
 */
public class CurvedLineAnimDrawable2 extends Drawable implements ValueAnimator.AnimatorUpdateListener {

    private static final String DEGREE_FACTOR="degreeFactor";
    private int durationMS=500;
    private final Paint mPaint2;
    private final RectF mRectF;
    private ObjectAnimator mLineAnim;
    private float degreeFactor;


    public CurvedLineAnimDrawable2(RectF rectF, Paint paint) {
        mPaint2 = paint == null ? getDefaultPaint() : paint;
        mRectF=rectF;
    }

    private Paint getDefaultPaint() {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setDither(true);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeWidth(5);
        p.setColor(Color.RED);
        return p;
    }

    private ObjectAnimator getCurvedLineAnim() {
        PropertyValuesHolder degreesPVH = PropertyValuesHolder.ofFloat(DEGREE_FACTOR,
                0f, 1f);
        ObjectAnimator lineAnim = ObjectAnimator.ofPropertyValuesHolder(
                this, degreesPVH).setDuration(durationMS);
        lineAnim.addUpdateListener(this);
        lineAnim.setAutoCancel(true);
        return lineAnim;
    }

    public void playAnim() {
        if (mLineAnim == null) {
            mLineAnim = getCurvedLineAnim();
        }
        if (mLineAnim.isRunning()) {
            mLineAnim.cancel();
        }
        mLineAnim.start();
    }


    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawArc(mRectF, 180, 180* degreeFactor, false, mPaint2);
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    public float getDegreeFactor() {
        return degreeFactor;
    }

    public void setDegreeFactor(float degreeFactor) {
        this.degreeFactor = degreeFactor;
    }

    public int getDurationMS() {
        return durationMS;
    }

    public void setDurationMS(int durationMS) {
        this.durationMS = durationMS;
    }
}
