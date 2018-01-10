package com.ahmadrosid.drawingview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;
    private DotView red, green, blue, gray, black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawingView);
        red = findViewById(R.id.dot1);
        green = findViewById(R.id.dot2);
        blue = findViewById(R.id.dot3);
        gray = findViewById(R.id.dot4);
        black = findViewById(R.id.dot5);

        red.setColorDot(Color.RED);
        green.setColorDot(Color.GREEN);
        blue.setColorDot(Color.BLUE);
        gray.setColorDot(Color.GRAY);
        black.setColorDot(Color.BLACK);

        changeColor(red);
        changeColor(green);
        changeColor(blue);
        changeColor(gray);
        changeColor(black);

    }

    private void changeColor(final DotView dotView){
        dotView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setDrawerColor(dotView.getColorDot());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clear){
            drawingView.clear();
        }
        return super.onOptionsItemSelected(item);

    }
}
