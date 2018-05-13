package com.example.nikolettatoth.recepies_andoid.ui.main;

import com.example.nikolettatoth.recepies_andoid.R;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailActivity;
import com.example.nikolettatoth.recepies_andoid.ui.main.adapter.ListAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen, SwipeRefreshLayout.OnRefreshListener, ListAdapter.ClickListener {

    @Inject
    MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecepiesApplication.injector.inject(this);

        recyclerView =findViewById(R.id.rViewMeals);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.loadMealsFromRepo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = "Main";
        Log.i("Meal", "Set new screen name: " + name);
    }

    @Override
    public void onRefresh() {
        mainPresenter.downloadMeals();
    }

    @Override
    public void showMeals(final List<MealModel> meals){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setRepository(meals);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onClick(MealModel mealitem) {
        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        i.putExtra("id", mealitem.getId());
        startActivity(i);
    }

}