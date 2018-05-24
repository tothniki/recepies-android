package com.example.nikolettatoth.recepies_andoid.ui.detail;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DetailPresenter extends Presenter<DetailScreen> {
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    public void loadMeal(final long id){
        executor.execute(new Runnable(){
            @Override
            public void run(){
                MealModel meal = repositoryInteractor.getMealById(id);
                screen.showMeal(meal);
            }
        });
    }

    @Override
    public void attachScreen(DetailScreen screen) {
        super.attachScreen(screen);
        RecepiesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
