package com.example.nikolettatoth.mock;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplicationComponent;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        RecepiesApplication app = (RecepiesApplication)RuntimeEnvironment.application;
        RecepiesApplicationComponent injector = DaggerTestComponent.builder().uIModule(new UIModule(app.getApplicationContext())).build();
        app.injector=injector;

    }
}