package com.example.nikolettatoth.recepies_andoid;

import com.example.nikolettatoth.recepies_andoid.interactor.InteractorModule;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;
import com.example.nikolettatoth.recepies_andoid.ui.about.AboutActivity;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class,
        InteractorModule.class})
public interface RecepiesApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);

    void inject(RecepiesInteractor recepiesInteractor);

    }


