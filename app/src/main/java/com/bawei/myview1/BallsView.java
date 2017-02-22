package com.bawei.myview1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 作    者：云凯文
 * 时    间：2016/12/26
 * 描    述：
 * 修改时间：
 */

public class BallsView extends View {

    //获取当前控件的高度和宽度
    private int height;
    private int width;
    private float x;
    private float y;
    //圆的半径
    private float radius = 100;
//    private boolean onBall;

    //获取的图片
    private Bitmap bitmap;
    private boolean flag = true;
    //图片的宽高
    private int bw;
    private int bh;


    private float x1;
    private float y1;


    public BallsView(Context context) {
        this(context, null);
    }

    public BallsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BallsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //在这里可以写逻辑
    }

    //测量的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取当前的宽度
        width = this.getWidth();
        //获取当前控件的高度
        height = this.getHeight();
        //求二分之一的宽高
        x = width / 2;
        y = height / 2;
        //设置自定义视图的大小
        setMeasuredDimension(200, 200);
    }

    //画布：Canvas
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //实例化一支画笔
        Paint paint = new Paint();
        //设置画笔的颜色
        paint.setColor(Color.RED);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置空心圆
        paint.setStyle(Paint.Style.STROKE);
        //画的图形是圆
        canvas.drawCircle(x, y, radius, paint);
        //第二个圆
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x, y, radius / 2, paint);


        //设置的是一张图片
        /**if (flag) {
         bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pic_screen);
         bw = bitmap.getWidth() / 2;
         bh = bitmap.getHeight() / 2;
         flag = false;
         }
         canvas.drawBitmap(bitmap, x - bw, y - bh, null);*/

    }

    //圆的触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //获取当前按下的位置
                x1 = event.getX();
                y1 = event.getY();

//                onBall = isOnBall(x1, y1);
//                Toast.makeText(getContext(), onBall+"", Toast.LENGTH_SHORT).show();


                //计算
                float sqrt = (float) Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
                if (sqrt < radius / 2) {
                    Toast.makeText(getContext(), "小圆内呢", Toast.LENGTH_SHORT).show();
                } else if (sqrt > radius / 2 && sqrt < radius) {
                    Toast.makeText(getContext(), "在圆环呢", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "在圆外", Toast.LENGTH_SHORT).show();
                }
                break;

            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
//                x = event.getX();
//                y = event.getY();
//                //调用到onDraw的方法
//                postInvalidate();
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    private boolean isOnBall(float x1, float y1) {

        float sqrt = (float) Math.sqrt((x1 - x) * (x1 - x )+ (y1 - y) * (y1 - y));
        if(sqrt<=radius){
            return true;
        }
        return false;
    }
}
