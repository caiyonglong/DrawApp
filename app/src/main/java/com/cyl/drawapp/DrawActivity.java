package com.cyl.drawapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by D22434 on 2017/10/18.
 */

public class DrawActivity extends AppCompatActivity {

    TailView2 drawCanvas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        drawCanvas = (TailView2) findViewById(R.id.draw_canvas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.draw_clear) {
//            drawCanvas.clearCanvas();
        }
        return super.onOptionsItemSelected(item);
    }
}
