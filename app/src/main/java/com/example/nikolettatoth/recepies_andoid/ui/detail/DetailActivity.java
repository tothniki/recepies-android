package com.example.nikolettatoth.recepies_andoid.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailScreen{
    private FirebaseAnalytics mFirebaseAnalytics;
    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
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
    public void showMeal(MealModel meal) {

    }
}
