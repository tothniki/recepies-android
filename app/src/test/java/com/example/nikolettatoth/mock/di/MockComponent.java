package com.example.nikolettatoth.mock.di;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplicationComponent;
import com.example.nikolettatoth.recepies_andoid.interactor.InteractorModule;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={UIModule.class, InteractorModule.class, MockDBModule.class, MockAPIModule.class})
public interface MockComponent extends RecepiesApplicationComponent {
}
