package com.example.nikolettatoth.mock.di;

import com.example.nikolettatoth.mock.api.MockAPI;
import com.example.nikolettatoth.recepies_andoid.network.api.MealApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockAPIModule {
    @Singleton
    @Provides
    public MealApi provideMealApi() {
        return new MockAPI();
    }
}