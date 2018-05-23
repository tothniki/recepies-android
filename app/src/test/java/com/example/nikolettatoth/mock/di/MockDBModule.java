package com.example.nikolettatoth.mock.di;

import com.example.nikolettatoth.mock.db.MockDB;
import com.example.nikolettatoth.recepies_andoid.database.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDBModule {
    @Provides
    @Singleton
    public Repository provideMealDB() {
        return new MockDB();
    }
}