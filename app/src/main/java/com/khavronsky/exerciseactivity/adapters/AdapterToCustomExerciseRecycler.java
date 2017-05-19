package com.khavronsky.exerciseactivity.adapters;


import com.khavronsky.exerciseactivity.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterToCustomExerciseRecycler extends RecyclerView.Adapter<AdapterToCustomExerciseRecycler.CustomExerciseHolder> {

    List<Object> customExList;

    @Override
    public CustomExerciseHolder onCreateViewHolder(final ViewGroup parent,
            final int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.custom_exercise_recycler_item, parent, false);
        return new CustomExerciseHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomExerciseHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomExerciseHolder extends RecyclerView.ViewHolder {

        CustomExerciseHolder(final View itemView) {
            super(itemView);
        }
    }
}
