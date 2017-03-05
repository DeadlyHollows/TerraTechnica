package com.example.directioner.terratechnica.EventCateg;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.example.directioner.terratechnica.R;

/**
 * Created by Directioner on 1/28/2017.
 */

public class Events extends ActionBarActivity {

    CollectionPagerAdapter mCollectionPagerAdapter;

    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        // Create an adapter that when requested, will return a fragment representing an object in
        // the collection.
        //
        // ViewPager and its adapters use support library fragments, so we must use
        // getSupportFragmentManager.
        mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());

        // Set up action bar.

        // Specify that the Home button should show an "Up" caret, indicating that touching the
        // button will take the user one step up in the application's hierarchy.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCollectionPagerAdapter);

        ((PagerTabStrip) findViewById(R.id.pager_tab_strip)).setTabIndicatorColor(Color.parseColor("#ffcc00"));
    }

    public static class CollectionPagerAdapter extends FragmentStatePagerAdapter {

        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;
            switch (i) {
                case 0:
                    // Fragment for CodeConnect
                    fragment = new CodeConnect();
                    break;
                case 1:
                    // Fragment for Botmania
                    fragment = new Botmania();
                    break;
                case 2:
                    // Fragment for Workshops
                    fragment = new Workshops();
                    break;
                case 3:
                    // Fragment for Informal
                    fragment = new Informals();
                    break;
            }


//            Bundle args = new Bundle();
//            args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1); // Our object is just an integer :-P
//            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String title = "";

            switch (position) {
                case 0:
                    title = "CodeConnect";
                    break;
                case 1:
                    title = "Botmania";
                    break;
                case 2:
                    title = "Workshops";
                    break;
                case 3:
                    title = "Informals";
                    break;
            }
            return title;
        }
    }
}