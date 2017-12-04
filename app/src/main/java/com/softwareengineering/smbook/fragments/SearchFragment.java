package com.softwareengineering.smbook.fragments;

/**
 * Created by Irina on 11/23/2017.
 */

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends Fragment {
    public  static  final String SEARCH_FRAGMENT_BACKSTACK_TAG = "Search_fragment_backstack_tag";
    TabLayout tabLayout;
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        setHasOptionsMenu(true);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("Cinemas"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pos = tab.getPosition();
                if (pos == 0) {
                    Toast.makeText(App.getContext(), "Load movies search", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(App.getContext(), "Load cinemas search", Toast.LENGTH_LONG).show();
                }
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

    @OnClick(R.id.ok_btn)
    public void ok_btn_pressed(View view) {
        EditText search_et = (EditText)getActivity().findViewById(R.id.search_et);
        Toast.makeText(App.getContext(), search_et.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_abouts, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Toast.makeText(App.getContext(), "Back", Toast.LENGTH_LONG).show();
                getActivity().onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
