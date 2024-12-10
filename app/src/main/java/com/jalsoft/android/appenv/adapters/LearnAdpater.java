package com.jalsoft.android.appenv.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jalsoft.android.appenv.fragments.AllLearn;
import com.jalsoft.android.appenv.fragments.BooksLearn;
import com.jalsoft.android.appenv.fragments.DiscussLearn;
import com.jalsoft.android.appenv.fragments.ImagesLearn;
import com.jalsoft.android.appenv.fragments.VideosLearn;

public class LearnAdpater extends FragmentStateAdapter {
    public LearnAdpater(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AllLearn();
            case 1:
                return new ImagesLearn();
            case 2:
                return new VideosLearn();
            case 3:
                return new BooksLearn();
            case 4:
                return new DiscussLearn();
            default:
                return new AllLearn();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
