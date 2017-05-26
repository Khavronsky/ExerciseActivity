package com.khavronsky.exerciseactivity.adapters;


import com.khavronsky.exerciseactivity.R;
import com.khavronsky.exerciseactivity.models.CustomExModel;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterToCustomExerciseRecycler
        extends RecyclerView.Adapter<AdapterToCustomExerciseRecycler.CustomExerciseHolder> {

    private List<CustomExModel> customExList;

    private FragmentManager mFragmentManager;

    public AdapterToCustomExerciseRecycler(final List<CustomExModel> customExList,
            FragmentManager fragmentManager) {
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
     * V I E W   H O L D E R
     */
    class CustomExerciseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.custom_exercise_item_title)
        TextView itemTitle;

        @BindView(R.id.custom_exercise_item_sub_title)
        TextView itemSubtitle;

        @BindView(R.id.custom_exercise_menu)
        ImageView itemMenu;

        @BindView(R.id.anchor)
        View mView;

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

        void setText(String title, String subTitle) {
            itemTitle.setText("Титыль");
            itemSubtitle.setText("СубТитыль");
        }

        @OnClick(R.id.custom_exercise_menu)
        void showMenu() {
            PopupMenu popupMenu = new PopupMenu(mView.getContext(), mView, Gravity.END);
            popupMenu.inflate(R.menu.popup_menu); // Для Android 4.0
            // для версии Android 3.0 нужно использовать длинный вариант
            // popupMenu.getMenuInflater().inflate(R.menu.popupmenu,
            // popupMenu.getMenu());

            popupMenu
                    .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            // Toast.makeText(PopupMenuDemoActivity.this,
                            // item.toString(), Toast.LENGTH_LONG).show();
                            // return true;
                            switch (item.getItemId()) {

                                case R.id.custom_exercise_item_menu_del:
                                    Toast.makeText(itemMenu.getContext(),
                                            "DELETE",
                                            Toast.LENGTH_SHORT).show();
                                    return true;
                                case R.id.custom_exercise_item_menu_edit:
                                    Toast.makeText(itemMenu.getContext(),
                                            "EDIT",
                                            Toast.LENGTH_SHORT).show();
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });

            popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {

                @Override
                public void onDismiss(PopupMenu menu) {
                    Toast.makeText(itemMenu.getContext(), "onDismiss",
                            Toast.LENGTH_SHORT).show();
                }
            });
            popupMenu.show();
        }

    }
}
