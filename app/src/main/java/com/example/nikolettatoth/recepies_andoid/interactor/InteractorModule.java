package com.example.nikolettatoth.recepies_andoid.interactor;

import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public RecepiesInteractor provideRecepiesInteractor() {
        return new RecepiesInteractor();
    }

    @Singleton
    @Provides
    public RepositoryInteractor provideRepositoryInteractor(){return new RepositoryInteractor();}
}