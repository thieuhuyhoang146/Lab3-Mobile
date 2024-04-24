package com.example.exercise3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    Bitmap[] frames = new Bitmap[30];  // Changed from 128 to 30 since you are only using 30 frames
    int i = 0;
    private Paint paint = new Paint();  // Create a single Paint instance for reuse

    public GraphicsView(Context context) {
        super(context);
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro00);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro01);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro02);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro03);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro04);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro05);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro06);
        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro07);
        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro08);
        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro09);
        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro10);
        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro11);
        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro12);
        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro13);
        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro14);
        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro15);
        frames[16] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro16);
        frames[17] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro17);
        frames[18] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro18);
        frames[19] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro19);
        frames[20] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro20);
        frames[21] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro21);
        frames[22] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro22);
        frames[23] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro23);
        frames[24] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro24);
        frames[25] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro25);
        frames[26] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro26);
        frames[27] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro27);
        frames[28] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro28);
        frames[29] = BitmapFactory.decodeResource(getResources(), R.drawable.tanjiro29);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 30) {
            canvas.scale(0.75f, 0.8f);
            canvas.drawBitmap(frames[i], 40, 40, paint);
        } else {
            i = 0;  // Reset index to 0 to loop the animation
        }
        invalidate();  // Request to redraw the view for animation
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i = (i + 1) % 30;  // Ensure the index is within the range of 0-29
        invalidate();  // Request to redraw the view with the next frame
        return true;
    }
}
