package com.khavronsky.exerciseactivity.fragments;

import com.khavronsky.exerciseactivity.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class CustomExercisesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_exercises_fragment, container, false);
        TextView createBtn = (TextView) view.findViewById(R.id.custom_exercise_create_btn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getContext(), "CREATE NEW EXERCISE", Toast.LENGTH_SHORT).show();
            }
        });
        return view;    }

}
