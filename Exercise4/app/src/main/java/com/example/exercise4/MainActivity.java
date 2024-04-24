package com.example.exercise4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private GraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        graphicView = new GraphicView(this); // Initialize GraphicView
        setContentView(graphicView); // Set the view
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (graphicView != null) {
            graphicView.releaseMediaPlayer(); // Ensure media player is released
        }
    }
}
