package com.khavronsky.exerciseactivity.fragments;

import com.khavronsky.exerciseactivity.ModelOfItemForExCatalog;
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

import static com.khavronsky.exerciseactivity.ModelOfItemForExCatalog.ItemType.CAPITAL_LETTER;
import static com.khavronsky.exerciseactivity.ModelOfItemForExCatalog.ItemType.EXERCISE_TITLE;


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
        adapterToExCatalogRecycler.setExerciseCatalog(new ArrayList<ModelOfItemForExCatalog>(){
            {
                add(new ModelOfItemForExCatalog("A", CAPITAL_LETTER));

                for (int i = 0; i < 20; i++) {
                    add(new ModelOfItemForExCatalog(("abc" + i), EXERCISE_TITLE));

                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterToExCatalogRecycler);
        adapterToExCatalogRecycler.notifyDataSetChanged();
        return view;
    }

}
