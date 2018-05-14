package com.example.nikolettatoth.recepies_andoid.database;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> v = SugarRecord.listAll(MealModel.class);
        return v;
    }

    @Override
    public MealModel getMealById(final long id) {
       MealModel v = SugarRecord.findById(MealModel.class, id);
       if(v !=null){
           return v;
       }
        return new MealModel();
    }

    @Override
    public void saveMeal(MealModel meal) {
        SugarRecord.saveInTx(meal);
    }

    @Override
    public void saveAllMeals(List<MealModel> meals) {
        int i=0;
        for (MealModel m : meals) {
            SugarRecord.save(m);
            i++;
        }
        i=i+1;
       // SugarRecord.saveInTx(meals);
    }

    @Override
    public void updateMeals(List<MealModel> newMiels) {
        List<MealModel> oldMiels = getAllMeals();
        List<MealModel> toUpdate = new ArrayList<>(oldMiels.size());
        for (MealModel oldmeal : oldMiels) {
            for (MealModel newmeal : newMiels) {
                if (newmeal.getId()==oldmeal.getId()) {
                    toUpdate.add(newmeal);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeMeal(MealModel meal) {
        SugarRecord.deleteInTx(meal);
    }

    @Override
    public void removeAll(){
        SugarRecord.deleteAll(MealModel.class);
    }

    @Override
    public boolean isInDB(MealModel meal) {
        return SugarRecord.findById(MealModel.class, meal.getId()) != null;
    }

}