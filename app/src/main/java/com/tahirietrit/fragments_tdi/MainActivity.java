package com.tahirietrit.fragments_tdi;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    Button fragment1;
    Button fragment2;
    Button fragment3;
    ViewPager fragmentViewPager;
    LessonPagerAdapter adapter;
    SimplePagerAdapter simplePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment1 = findViewById(R.id.fragment_1);
        fragment2 = findViewById(R.id.fragment_2);
        fragment3 = findViewById(R.id.fragment_3);
        fragmentViewPager = findViewById(R.id.fragment_pager);
        adapter = new LessonPagerAdapter(getSupportFragmentManager());
        simplePagerAdapter = new SimplePagerAdapter(getLayoutInflater());
        fragmentViewPager.setAdapter(simplePagerAdapter);
        selectButton();
        fragmentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                selectButton();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = fragmentViewPager.getCurrentItem() - 1;
                if(pos>=0) {
                    fragmentViewPager.setCurrentItem(pos);
                }
            }
        });
        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = fragmentViewPager.getCurrentItem() + 1;
                if(pos <=fragmentViewPager.getChildCount()) {
                    fragmentViewPager.setCurrentItem(pos);
                }

            }
        });
    }


    private void selectButton() {
        fragment1.setTextColor(Color.BLACK);
        fragment2.setTextColor(Color.BLACK);
        fragment3.setTextColor(Color.BLACK);
        fragment1.setBackgroundColor(Color.GRAY);
        fragment2.setBackgroundColor(Color.GRAY);
        fragment3.setBackgroundColor(Color.GRAY);
        switch (fragmentViewPager.getCurrentItem()) {
            case 0: {
                fragment1.setTextColor(Color.WHITE);
                fragment1.setBackgroundColor(Color.BLACK);
            }
            break;
            case 1: {
                fragment2.setTextColor(Color.WHITE);
                fragment2.setBackgroundColor(Color.BLACK);
            }
            break;
            case 2: {
                fragment3.setTextColor(Color.WHITE);
                fragment3.setBackgroundColor(Color.BLACK);
            }
            break;
        }
    }

}
