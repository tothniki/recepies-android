package com.example.nikolettatoth.recepies_andoid.ui.main;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    RecepiesInteractor recepiesInteractor;

    public MainPresenter(){
        RecepiesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
