package com.example.nikolettatoth.recepies_andoid.interactor;

import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public RecepiesInteractor provideRecepiesInteractor() {
        return new RecepiesInteractor();
    }
}