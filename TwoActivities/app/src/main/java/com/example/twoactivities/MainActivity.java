package com.example.twoactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize all the view variables
        mShowCount = findViewById(R.id.show_count);

        // restore the state
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            mShowCount.setText("" + count);
        }
    }

    public void countUp(View view) {
        ++count;
        mShowCount.setText("" + count);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}