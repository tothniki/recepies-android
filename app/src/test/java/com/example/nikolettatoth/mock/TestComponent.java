package com.example.nikolettatoth.mock;

import com.example.nikolettatoth.mock.di.MockAPIModule;
import com.example.nikolettatoth.mock.di.MockDBModule;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplicationComponent;
import com.example.nikolettatoth.recepies_andoid.interactor.InteractorModule;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockDBModule.class, MockAPIModule.class, UIModule.class, InteractorModule.class})
public interface TestComponent extends RecepiesApplicationComponent {
}
