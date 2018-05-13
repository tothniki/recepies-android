package com.example.nikolettatoth.recepies_andoid;

import com.example.nikolettatoth.recepies_andoid.database.RepositoryModule;
import com.example.nikolettatoth.recepies_andoid.interactor.InteractorModule;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.network.NetworkModul;
import com.example.nikolettatoth.recepies_andoid.ui.UIModule;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailActivity;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailPresenter;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainActivity;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class,
        InteractorModule.class, NetworkModul.class, RepositoryModule.class})
public interface RecepiesApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);

    void inject(DetailActivity detailActivity);
    void inject(DetailPresenter detailPresenter);

    void inject(RecepiesInteractor recepiesInteractor);
    void inject(RepositoryInteractor repositoryInteractor);

    //void inject(RecepiesApplication recepiesApplication);



    }


