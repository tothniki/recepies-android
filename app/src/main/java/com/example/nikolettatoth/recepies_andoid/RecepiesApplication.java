package com.example.nikolettatoth.recepies_andoid;

import android.app.Application;

import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

public class RecepiesApplication extends Application {
    public static RecepiesApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerRecepiesApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
