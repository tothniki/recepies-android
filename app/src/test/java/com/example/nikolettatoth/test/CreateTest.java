package com.example.nikolettatoth.test;

import com.example.nikolettatoth.mock.db.MockDB;
import com.example.nikolettatoth.recepies_andoid.BuildConfig;
import com.example.nikolettatoth.mock.TestHelper;
import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor_MembersInjector;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.create.CreateActivity;
import com.example.nikolettatoth.recepies_andoid.ui.create.CreatePresenter;
import com.example.nikolettatoth.recepies_andoid.ui.create.CreateScreen;
import com.example.nikolettatoth.recepies_andoid.ui.main.MainActivity;
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class CreateTest {
    private CreatePresenter createPresenter;
    private CreateScreen createScreen;
    private CountDownLatch latch;
    private MealModel meal;
    private MockDB db;
    private RepositoryInteractor i;


    @Before
    public void Before() {
        TestHelper.setTestInjector();
        createScreen = mock(CreateScreen.class);
        createPresenter = new CreatePresenter();
        createPresenter.attachScreen(createScreen);
        db = new MockDB();
        i = mock(RepositoryInteractor.class);



        latch = new CountDownLatch(1);
        meal = new MealModel(){{
            setId(10);
            setName("a");
            setPicture("b");
            setInstructions("c");
            setIngredients("d");
        }};

    }

    @Test
    public void saveMeal() throws InterruptedException {
        createPresenter.saveMeal(meal);
        latch.await(200, TimeUnit.MILLISECONDS);
        ArgumentCaptor<MealModel> capture = ArgumentCaptor.forClass(MealModel.class);
        verify(createScreen).showMeal(capture.capture());

        assertEquals((Long)10L,capture.getValue().getId());
    }

    @After
    public void After(){
        createPresenter.detachScreen();
    }
}