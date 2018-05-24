package com.example.nikolettatoth.test;

import com.example.nikolettatoth.mock.TestHelper;
import com.example.nikolettatoth.recepies_andoid.BuildConfig;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.network.model.MealInCategory;
import com.example.nikolettatoth.recepies_andoid.network.model.Meals;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainPresenter;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {
    private MainPresenter mainPresenter;
    private MainScreen mainScreen;
    private CountDownLatch latch;

    @Before
    public void Before(){
        TestHelper.setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
        latch = new CountDownLatch(1);
    }

    @Test
    public void downloadMeals() throws InterruptedException {
        mainPresenter.downloadMeals();
        latch.await(200, TimeUnit.MILLISECONDS);
        ArgumentCaptor<List> capture = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showMeals(capture.capture());

        assertEquals(2,capture.getValue().size());

        List<MealModel>meals = capture.getValue();
        assertEquals((Long) 1L, meals.get(0).getId());
    }

    @After
    public void After() {
       mainPresenter.detachScreen();
    }
}
