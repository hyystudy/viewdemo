package com.example.sks.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by sks on 2016/11/28.
 */
public class FlashTextView extends TextView {

    private Matrix matrix;
    private Paint paint;
    private Bitmap mBitmap;
    private static int REFRESH_DURATION = 15;        //refresh duration
    private static int ANIM_DURATION = 3000;        //animation duration
    private static float VE_HORIZONTAL = 0.062f;        //水平方向前进速率
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    if (mStarted){
                        refresh();
                    }
                    //invalidate();
                    break;
            }
            return true;
        }
    });
    private int mScreenWidth;
    private int mTranslateDistance;
    private boolean mStarted;

    private void refresh() {
        if (mBitmap != null) {
            Log.d("updateMatrix", "refresh: " + mLastMoveX);
            Log.d("updateMatrix", "REFRESH_DURATION: " + REFRESH_DURATION);
            Log.d("updateMatrix", "VE_HORIZONTAL: " + VE_HORIZONTAL);
            mLastMoveX = mLastMoveX + REFRESH_DURATION * VE_HORIZONTAL;
            updateMatrix(mLastMoveX, 0);
            if (getAlpha() == 0 || mLastMoveX > mTranslateDistance) {
                mLastMoveX = -mBitmap.getWidth();
            }
            mHandler.sendEmptyMessageDelayed(1, REFRESH_DURATION);
        }
    }

    private float mLastMoveX = 0;

    public FlashTextView(Context context) {
        super(context);
    }

    public FlashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        startAnimation();
    }

    private void startAnimation() {
        if (!mStarted){
            mStarted = true;
            mHandler.sendEmptyMessageDelayed(1, REFRESH_DURATION);
        }
    }

    private void stopAnimation() {
        mStarted = false;
    }

    private void initView() {

        setLayerType(LAYER_TYPE_HARDWARE, null);

        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mTranslateDistance = mScreenWidth * 2 / 3;
        VE_HORIZONTAL = mTranslateDistance * 1.f / ANIM_DURATION;

        matrix = new Matrix();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lc_bg_sweep);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));

        //updateMatrix(mBitmap.getWidth()/2, 0);
    }

    private void updateMatrix(float x, float y) {
        float x1 = x - mBitmap.getWidth() / 2;
        matrix.reset();
        matrix.postTranslate(x1, 0);
        invalidate();
    }

    public FlashTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, matrix, paint);
    }
}
