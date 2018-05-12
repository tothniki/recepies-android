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
    public List<MealModel> getMeals() {
        return SugarRecord.listAll(MealModel.class);
    }

    @Override
    public void saveMeal(MealModel meal) {
        SugarRecord.saveInTx(meal);
    }

    @Override
    public void updateMeals(List<MealModel> newMiels) {
        List<MealModel> oldMiels = getMeals();
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
    public boolean isInDB(MealModel meal) {
        return SugarRecord.findById(MealModel.class, meal.getId()) != null;
    }

}