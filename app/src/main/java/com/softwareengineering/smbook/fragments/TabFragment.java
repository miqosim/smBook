package com.softwareengineering.smbook.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.adapters.PagerAdapter;

import butterknife.ButterKnife;

/**
 * Created by Irina on 11/14/2017.
 */

public class TabFragment extends Fragment {

    public  static  final String TABFRAGMENT_BACKSTACK_TAG = "tab_fragment_backstack_tag";
    ViewPager viewPager;
    PagerAdapter adapter = null;
    TabLayout tabLayout;
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.tab_fragment_layout, container, false);
        ButterKnife.bind(this, view);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("MOVIES"));
        tabLayout.addTab(tabLayout.newTab().setText("CINEMAS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = view.findViewById(R.id.pager);
        if(adapter == null){
            adapter = new PagerAdapter
                    (getFragmentManager(), tabLayout.getTabCount());
        }

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pos = tab.getPosition();
                viewPager.setCurrentItem(pos);
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt("Position", pos).apply();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(adapter == null){
            adapter = new PagerAdapter
                    (getFragmentManager(), tabLayout.getTabCount());
        }


        if(viewPager !=null)
            viewPager.setCurrentItem(PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("Position", 0));

    }



}