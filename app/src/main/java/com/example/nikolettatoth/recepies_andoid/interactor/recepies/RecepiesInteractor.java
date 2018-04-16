package com.example.nikolettatoth.recepies_andoid.interactor.recepies;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;

import javax.inject.Inject;

public class RecepiesInteractor {

    //@Inject
    //RecepiesApi recepiesApi;

    public RecepiesInteractor(){
        RecepiesApplication.injector.inject(this);
    }
}
