package com.example.exercise4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GraphicView extends View {

    Bitmap[] frames = new Bitmap[128];
    int i = 0;
    long last_tick = 0;
    long period = 200;
    MediaPlayer mediaPlayer;

    public GraphicView(Context context) {
        super(context);
        for (int j = 0; j < 30; j++) { // Assuming you're initializing 30 frames as shown previously
            int resId = getResources().getIdentifier("tanjiro" + String.format("%02d", j), "drawable", context.getPackageName());
            frames[j] = BitmapFactory.decodeResource(getResources(), resId);
        }
        initMediaPlayer(context);
    }

    private void initMediaPlayer(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.tanjiro);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 30) {
            long time = System.currentTimeMillis() - last_tick;
            if (time >= period) {
                last_tick = System.currentTimeMillis();
                canvas.scale(0.75f, 0.8f);
                canvas.drawBitmap(frames[i], 40, 40, new Paint());
                i = (i + 1) % 30; // Making sure it cycles through the first 30 frames
                postInvalidateDelayed(period);
            } else {
                postInvalidateDelayed(time);
            }
        } else {
            i = 0;
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i = (i + 1) % 30; // Ensure it cycles through the first 30 frames
        postInvalidate();
        return true;
    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
