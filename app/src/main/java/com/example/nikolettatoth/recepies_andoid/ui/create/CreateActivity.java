package com.example.nikolettatoth.recepies_andoid.ui.create;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.nikolettatoth.recepies_andoid.R;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailActivity;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class CreateActivity extends AppCompatActivity implements CreateScreen {
    @Inject
    CreatePresenter createPresenter;
    @Inject
    RepositoryInteractor repositoryInteractor;

    String url = "https://szamos.hu/upload/3/36/m/36855db9b7201c789f632898cdbc2020.png";
    Long id;
    MealModel meal;
    TextInputEditText name;
    TextInputEditText image;
    TextInputEditText ingredients;
    TextInputEditText instructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        RecepiesApplication application = (RecepiesApplication) getApplication();
        RecepiesApplication.injector.inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("New recipe");

        name = findViewById(R.id.name_input);
        image = findViewById(R.id.url_input);
        ingredients = findViewById(R.id.ingr_input);
        instructions = findViewById(R.id.inst_input);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMeal();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
               // i.putExtra("id", meal.getId());
              //  i.putExtra("name", meal.getName());
                startActivity(i);
            }
        });
    }

    private void saveMeal(){
        meal = new MealModel();
        meal.setId(getNextID());
        meal.setName(name.getText().toString());
        meal.setIngredients(ingredients.getText().toString());
        meal.setInstructions(instructions.getText().toString());
        meal.setPicture(url);
        //meal.setPicture(image.getText().toString());
        createPresenter.saveMeal(meal);
    }

    private long getNextID(){
        List<MealModel> meals = repositoryInteractor.getAllMeals();
        int size = meals.size();
        long id = meals.get(size-1).getId()+1;
        return id;
    }

    @Override
    public void showMeal(MealModel m){

    }

    @Override
    protected void onStart() {
        super.onStart();
        createPresenter.attachScreen(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        createPresenter.detachScreen();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
