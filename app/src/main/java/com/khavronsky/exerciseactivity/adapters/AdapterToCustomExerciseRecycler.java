package com.khavronsky.exerciseactivity.adapters;


import com.khavronsky.exerciseactivity.R;
import com.khavronsky.exerciseactivity.dialogs.ExerciseCatalogItemMenuDialog;
import com.khavronsky.exerciseactivity.dialogs.IDialogFragment;
import com.khavronsky.exerciseactivity.models.CustomExModel;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterToCustomExerciseRecycler
        extends RecyclerView.Adapter<AdapterToCustomExerciseRecycler.CustomExerciseHolder> {

    private List<CustomExModel> customExList;
    private FragmentManager mFragmentManager;

    public AdapterToCustomExerciseRecycler(final List<CustomExModel> customExList, FragmentManager fragmentManager) {
        this.customExList = customExList;
        mFragmentManager = fragmentManager;

    }

    @Override
    public CustomExerciseHolder onCreateViewHolder(final ViewGroup parent,
            final int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.custom_exercise_recycler_item, parent, false);
        return new CustomExerciseHolder(view).setFragmentManager(mFragmentManager);
    }

    @Override
    public void onBindViewHolder(final CustomExerciseHolder holder, final int position) {
        holder.setText(customExList.get(position).getExTitle(), customExList.get(position).getExSubTitle());
    }

    @Override
    public int getItemCount() {
        return customExList == null ? 0 : customExList.size();
    }

    /**
     *      V I E W   H O L D E R
     */
    class CustomExerciseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.custom_exercise_item_title)
        TextView itemTitle;
        @BindView(R.id.custom_exercise_item_sub_title)
        TextView itemSubtitle;
        @BindView(R.id.custom_exercise_menu)
        ImageView itemMenu;

        FragmentManager mFragmentManager;

        public CustomExerciseHolder setFragmentManager(final FragmentManager fragmentManager) {
            mFragmentManager = fragmentManager;
            return this;
        }

        CustomExerciseHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(final View v) {
            showMenu();
        }

        void setText(String title, String subTitle){
            itemTitle.setText("Титыль");
            itemSubtitle.setText("СубТитыль");
        }

        @OnClick(R.id.custom_exercise_menu)
        void showMenu(){
            ExerciseCatalogItemMenuDialog dialogMenu = new ExerciseCatalogItemMenuDialog();
            dialogMenu.setCallback(new IDialogFragment() {
                @Override
                public void doButtonClick1() {
                    Log.d("KhS", "doButtonClick1: ");

                }

                @Override
                public void doButtonClick2() {
                    Log.d("KhS", "doButtonClick2: ");
                }

                @Override
                public void doByDismissed() {

                }
            });
            dialogMenu.show(mFragmentManager, "");
        }

    }
}
