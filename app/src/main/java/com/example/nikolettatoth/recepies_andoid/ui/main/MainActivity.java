package com.example.nikolettatoth.recepies_andoid.ui.main;

import com.example.nikolettatoth.recepies_andoid.R;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showMeals(final List<MealModel> meals){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //..;
            }
        });
    }

}