package com.jalsoft.android.appenv.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jalsoft.android.appenv.fragments.AllLearn;
import com.jalsoft.android.appenv.fragments.BooksLearn;
import com.jalsoft.android.appenv.fragments.VideosLearn;

public class LearnAdapter extends FragmentStateAdapter {
    public LearnAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 2:
                return new VideosLearn();
            case 3:
                return new BooksLearn();
            default:
                return new AllLearn(); // A default fragment for other tabs
        }
    }

    @Override
    public int getItemCount() {
        return 4; // Total number of tabs
    }
}

