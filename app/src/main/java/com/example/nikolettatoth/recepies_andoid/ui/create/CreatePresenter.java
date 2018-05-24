package com.example.nikolettatoth.recepies_andoid.ui.create;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.Presenter;

import java.io.IOException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class CreatePresenter extends Presenter<CreateScreen> {
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    public void saveMeal(final MealModel m){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                    repositoryInteractor.saveMeal(m);

            }
        });
    }

    @Override
    public void attachScreen(CreateScreen screen) {
        super.attachScreen(screen);
        RecepiesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

}
