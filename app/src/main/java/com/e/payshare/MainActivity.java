package com.e.payshare;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import adapter.ViewPagerAdapter;
import fragments.CashingFragment;
import fragments.FeedFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabId);
        viewpager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragments(new FeedFragment(),"Feed");
        adapter.addFragments(new CashingFragment(), "Cashing Up");

        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
    }
}
