package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jalsoft.android.appenv.adapters.LearnAdapter;

public class LearnActivity extends AppCompatActivity {
    TabLayout eduCont;
    ViewPager2 viewPager2;
    LearnAdapter learnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        eduCont = findViewById(R.id.nav_tab);
        viewPager2 = findViewById(R.id.view_pager);

        learnAdapter = new LearnAdapter(this);
        viewPager2.setAdapter(learnAdapter);

        eduCont.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                eduCont.getTabAt(position).select();
            }
        });
    }
}