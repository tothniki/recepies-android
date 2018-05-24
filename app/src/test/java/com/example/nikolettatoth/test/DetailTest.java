package com.example.nikolettatoth.test;

import com.example.nikolettatoth.mock.TestHelper;
import com.example.nikolettatoth.recepies_andoid.BuildConfig;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailPresenter;
import com.example.nikolettatoth.recepies_andoid.ui.detail.DetailScreen;

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
public class DetailTest {
    private DetailPresenter detailPresenter;
    private DetailScreen detailScreen;
    private CountDownLatch latch;

    @Before
    public void Before() {
        TestHelper.setTestInjector();
        detailScreen = mock(DetailScreen.class);
        detailPresenter = new DetailPresenter();
        detailPresenter.attachScreen(detailScreen);
        latch = new CountDownLatch(1);
    }

    @Test
    public void loadMeal() throws InterruptedException {
        detailPresenter.loadMeal(1);
        latch.await(200, TimeUnit.MILLISECONDS);

        ArgumentCaptor<MealModel> capture = ArgumentCaptor.forClass(MealModel.class);
        verify(detailScreen).showMeal(capture.capture());

        assertEquals("name",capture.getValue().getName());
        assertEquals("pic",capture.getValue().getPicture());
    }

    @After
    public void After(){
        detailPresenter.detachScreen();
    }
}