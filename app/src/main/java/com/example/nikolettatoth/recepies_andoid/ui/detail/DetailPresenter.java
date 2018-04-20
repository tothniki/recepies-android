package com.example.nikolettatoth.recepies_andoid.ui.detail;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.ui.Presenter;

import javax.inject.Inject;

public class DetailPresenter extends Presenter<DetailScreen> {
    @Inject
    RecepiesInteractor recepiesInteractor;

    public DetailPresenter(){
        RecepiesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(DetailScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
