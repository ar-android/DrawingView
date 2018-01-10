package com.ahmadrosid.drawingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by mymacbook on 1/10/18.
 */

public class DrawingView extends View {

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private int pathIndex = 0;
    private ArrayList<Path> pathLists = new ArrayList<>();
    private ArrayList<Paint> paintLists = new ArrayList<>();
    private int drawerColor = Color.BLACK;

    private void init() {
        pathLists.add(new Path());
        paintLists.add(createPaint());
        pathIndex++;
    }

    private Paint createPaint() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);
        paint.setColor(drawerColor);
        return paint;
    }

    private Path createPath(MotionEvent event) {
        Path path = new Path();
        path.moveTo(event.getX(), event.getY());
        return path;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                updateIndex(createPath(event));
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                Path path = pathLists.get(pathIndex - 1);
                path.lineTo(x, y);
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    private void updateIndex(Path path) {
        if (pathIndex == pathLists.size()) {
            pathLists.add(path);
            paintLists.add(createPaint());
            pathIndex++;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        for (int index = 0; index < pathIndex; index++) {
            Path path = pathLists.get(index);
            Paint paint = paintLists.get(index);
            canvas.drawPath(path, paint);
        }
    }

    public void setDrawerColor(int drawerColor) {
        this.drawerColor = drawerColor;
    }

    public void clear() {
        pathLists.clear();
        paintLists.clear();
        pathIndex = 0;
        invalidate();
    }
}