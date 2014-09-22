package com.dpt.widget;

import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dupengtao on 14-9-18.
 */
public class LineAnimHelper {


    public static NormalLineAnimDrawable drawRec(float x, float y, float width, float height, Paint paint) {
        NormalLineAnimDrawable animDrawable = new NormalLineAnimDrawable(paint);
        List<AnimPoint> animPoints = new ArrayList<AnimPoint>(4);
        float w = x + width;
        float h = y+height;
        animPoints.add(new AnimPoint(x, y, w, y));
        animPoints.add(new AnimPoint(w, y, w, h));
        animPoints.add(new AnimPoint(w, h, x, h));
        animPoints.add(new AnimPoint(x, h, x, y));
        animDrawable.setPoints(animPoints);
        return animDrawable;
    }

    public static NormalLineAnimDrawable drawLine(float curX, float curY, float moveX, float moveY, Paint paint) {
        NormalLineAnimDrawable animDrawable = new NormalLineAnimDrawable(paint);
        List<AnimPoint> animPoints = new ArrayList<AnimPoint>();
        animPoints.add(new AnimPoint(curX, curY, moveX, moveY));
        animDrawable.setPoints(animPoints);
        return animDrawable;
    }

    public static NormalLineAnimDrawable drawShape(List<AnimPoint> animPoints, Paint paint) {
        NormalLineAnimDrawable animDrawable = new NormalLineAnimDrawable(paint);
        animDrawable.setPoints(animPoints);
        return animDrawable;
    }

    public static CurvedLineAnimDrawable2 drawCurvedLine(RectF rectF, Paint paint) {
        CurvedLineAnimDrawable2 drawable2 = new CurvedLineAnimDrawable2(rectF,paint);
        return drawable2;
    }
}
