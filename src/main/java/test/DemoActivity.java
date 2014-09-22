package test;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import com.dpt.widget.*;

import java.util.ArrayList;
import java.util.List;


public class DemoActivity extends Activity {
    private NormalLineAnimDrawable animDrawable1;
    private NormalLineAnimDrawable animDrawable2;
    private NormalLineAnimDrawable animDrawable3;
    private CurvedLineAnimDrawable2 curvedLineAnimDrawable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<AnimPoint> animPoints = new ArrayList<AnimPoint>();
        animPoints.add(new AnimPoint(50, 50, 300, 50));
        animPoints.add(new AnimPoint(300, 50, 300, 300));
        animPoints.add(new AnimPoint(300, 300, 50, 300));
        animPoints.add(new AnimPoint(50, 300, 50, 50));
        animPoints.add(new AnimPoint(50, 50, 300, 300));
        animDrawable1= LineAnimHelper.drawShape(animPoints, null);
        findViewById(R.id.v1).setBackground(animDrawable1);
        animDrawable2=LineAnimHelper.drawShape(animPoints,null);
        animDrawable2.setCurDisplayMode(NormalLineAnimDrawable.DisplayMode.Disappear);
        findViewById(R.id.v2).setBackground(animDrawable2);
        animDrawable3 = LineAnimHelper.drawRec(50, 50, 100, 150, null);
        findViewById(R.id.v3).setBackground(animDrawable3);
        curvedLineAnimDrawable2=LineAnimHelper.drawCurvedLine(new RectF(100,100,300,300),null);
        findViewById(R.id.v5).setBackground(curvedLineAnimDrawable2);
    }

    public void beginAnim(View view) {
        animDrawable1.playAnim();
        animDrawable2.playAnim();
        animDrawable3.playAnim();
        curvedLineAnimDrawable2.playAnim();
    }

}
