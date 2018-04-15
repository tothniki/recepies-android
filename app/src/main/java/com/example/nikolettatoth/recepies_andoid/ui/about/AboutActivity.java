package com.example.nikolettatoth.recepies_andoid.ui.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nikolettatoth.recepies_andoid.R;

public class AboutActivity extends AppCompatActivity implements AboutScreen {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
