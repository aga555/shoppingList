package com.example.shoppinglist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

class DrawView extends View implements View.OnTouchListener {

    Paint paint = new Paint();
    Point point = new Point();

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    canvas.drawCircle(point.x,point.y,30,paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        invalidate();
        return false;
    }
}
