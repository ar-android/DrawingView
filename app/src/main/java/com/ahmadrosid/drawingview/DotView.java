package com.ahmadrosid.drawingview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

import static android.graphics.Bitmap.Config.ALPHA_8;
import static android.graphics.Paint.ANTI_ALIAS_FLAG;

/**
 * Created by mymacbook on 1/10/18.
 */

public class DotView extends View {

    private int colorDot;

    public DotView(Context context) {
        super(context);
        init();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        colorDot = Color.BLACK;
    }

    public void setColorDot(int colorDot) {
        this.colorDot = colorDot;
    }

    public int getColorDot() {
        return colorDot;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLayout(canvas);
    }

    private void drawLayout(Canvas canvas) {
        RectF rectf = new RectF(5, 5, canvas.getWidth() - 5, canvas.getHeight() - 5);
        canvas.drawOval(rectf, createPaint(colorDot));
    }

    private Paint createPaint(int color) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setAntiAlias(true);
        return paint;
    }
}
