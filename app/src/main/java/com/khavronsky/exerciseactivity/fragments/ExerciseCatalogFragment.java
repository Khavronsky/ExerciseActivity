package com.khavronsky.exerciseactivity.fragments;

import com.khavronsky.exerciseactivity.R;
import com.khavronsky.exerciseactivity.adapters.AdapterToExCatalogRecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ExerciseCatalogFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exercise_catalog_fragment, container, false);
        Log.d("KhS", "onCreateView: ");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.exercise_catalog_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AdapterToExCatalogRecycler adapterToExCatalogRecycler = new AdapterToExCatalogRecycler();
        adapterToExCatalogRecycler.setExerciseCatalog(new ArrayList<String>(){
            {
                for (int i = 0; i < 20; i++) {
                    add("abc" + i);

                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterToExCatalogRecycler);
        adapterToExCatalogRecycler.notifyDataSetChanged();
        return view;
    }

}
