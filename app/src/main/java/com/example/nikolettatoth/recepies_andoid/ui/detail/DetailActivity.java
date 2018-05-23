package com.example.nikolettatoth.recepies_andoid.ui.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikolettatoth.recepies_andoid.R;
import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import static java.lang.String.join;

public class DetailActivity extends AppCompatActivity implements DetailScreen{
    private FirebaseAnalytics mFirebaseAnalytics;
    @Inject
    DetailPresenter detailPresenter;

    Long id;
    MealModel meal;
    ImageView image;
    TextView ingredients;
    TextView instructions;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        RecepiesApplication application = (RecepiesApplication) getApplication();

        setContentView(R.layout.activity_detail);

        RecepiesApplication.injector.inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        id = i.getLongExtra("id",0);
        String name = i.getStringExtra("name");
        setTitle(name);

        image = findViewById(R.id.recipe_img);
        ingredients = findViewById(R.id.recipe_ingred);
        instructions = findViewById(R.id.recipe_instr);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachScreen(this);
        detailPresenter.loadMeal(id);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailPresenter.detachScreen();
    }

    @Override
    public void showMeal(final MealModel meal) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ingredients.setText(getIngredients(meal.getIngredients()));
                instructions.setText(meal.getInstructions());
                new DownloadImageTask(image).execute(meal.getPicture());
            }
        });
    }

    private String getIngredients(String list){
        list = list.toString();
        return list;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
