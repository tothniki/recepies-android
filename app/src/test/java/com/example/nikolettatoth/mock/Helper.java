package com.example.nikolettatoth.mock;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplicationComponent;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class Helper {
    public static void setInjector() {
        ShadowLog.stream = System.out;
        RecepiesApplication application = (RecepiesApplication) RuntimeEnvironment.application;
        RecepiesApplicationComponent injector = DaggerMockComponent.builder().uIModule(new UIModule(application.getApplicationContext())).build();
        application.injector = injector;

    }
}
