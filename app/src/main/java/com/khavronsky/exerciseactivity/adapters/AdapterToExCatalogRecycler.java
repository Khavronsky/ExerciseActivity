package com.khavronsky.exerciseactivity.adapters;


import com.khavronsky.exerciseactivity.R;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterToExCatalogRecycler extends RecyclerView.Adapter<AdapterToExCatalogRecycler.ExerciseCatalogHolder> {

    private List<String> exerciseCatalog = new ArrayList<>();

    public AdapterToExCatalogRecycler setExerciseCatalog(final List<String> exerciseCatalog) {
        this.exerciseCatalog = exerciseCatalog;
        Log.d("KhS", "setExerciseCatalog: ");
        return this;
    }

    @Override
    public ExerciseCatalogHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.exercise_catalog_recycler_item, parent, false);
        Log.d("KhS", "onCreateViewHolder: ");
        return new ExerciseCatalogHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExerciseCatalogHolder holder, final int position) {
        holder.setText(exerciseCatalog.get(position));
        Log.d("KhS", "onBindViewHolder: "+ exerciseCatalog.get(position));
    }

    @Override
    public int getItemCount() {
        return exerciseCatalog == null? 0: exerciseCatalog.size();
    }
/**
 *      V I E W   H O L D E R
 * */
    class ExerciseCatalogHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ExerciseCatalogHolder(final View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.exercise_name);
            Log.d("KhS", "ExerciseCatalogHolder: ");
        }

        void setText(String text){
            mTextView.setText(text);
        }
    }

}
