package com.example.nikolettatoth.recepies_andoid.ui.main.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikolettatoth.recepies_andoid.R;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<MealModel> meals ;
    private ClickListener  listener;

    public ListAdapter() {
        this.meals = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MealModel meal = meals.get(position);
        holder.mealitem = meal;
        holder.textView.setText(meal.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onClick(holder.mealitem);
                }
            }
        });
      //  new DownloadImageTask(holder.imageView).execute(meal.getPicture());

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public MealModel mealitem;
        public View view;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView)itemView.findViewById(R.id.recipe_title);
            imageView = (ImageView) itemView.findViewById(R.id.recipe_img);
        }
    }

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public void setRepository(List<MealModel> meals) {
        this.meals = meals;
        this.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(MealModel item);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}


