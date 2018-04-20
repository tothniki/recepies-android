package com.example.nikolettatoth.recepies_andoid.network;

import com.example.nikolettatoth.recepies_andoid.network.api.MealApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModul {
    @Singleton
    @Provides
    public MealApi provideMealApi(){
        return new ApiClient().createService(MealApi.class);

    }
}
