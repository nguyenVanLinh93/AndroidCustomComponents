package com.example.nguyenlinh.androidcustomcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Main Screen
 *
 * @author nguyenlinh
 * @version 1.0
 * @since 2017-2-17
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Add a TouchEvent handler so that it turns yellow when you press/click on it.
     *
     * @param view
     */
    public void changeColor(View view){
        ColoredView coloredView = (ColoredView)view;
        coloredView.changeColor();
    }
}
