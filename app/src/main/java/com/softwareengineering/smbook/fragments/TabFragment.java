package com.softwareengineering.smbook.fragments;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;
import com.softwareengineering.smbook.adapters.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;


public class TabFragment extends Fragment {

    public  static  final String TABFRAGMENT_BACKSTACK_TAG = "tab_fragment_backstack_tag";
    ViewPager viewPager;
    PagerAdapter adapter = null;
    TabLayout tabLayout;
    int pos;
    private Context mContext;

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
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Toast.makeText(App.getContext(), "Back", Toast.LENGTH_LONG).show();
                getActivity().onBackPressed();
                return true;
            case R.id.action_city_filter:
                Toast.makeText(App.getContext(), "City Filter", Toast.LENGTH_LONG).show();
                //Initialize the Alert Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//Source of the data in the DIalog
                CharSequence[] array = {"Yerevan", "Gyumri", "Vanadzor"};

// Set the dialog title
                builder.setTitle("Select Priority")
// Specify the list array, the items to be selected by default (null for none),
// and the listener through which to receive callbacks when items are selected
                        .setSingleChoiceItems(array, 1, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub

                            }
                        })

// Set the action buttons
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
// User clicked OK, so save the result somewhere
// or return them to the component that opened the dialog

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                Dialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.action_search:
                Toast.makeText(App.getContext(), "Filtered Search", Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SearchFragment()).addToBackStack(SearchFragment.SEARCH_FRAGMENT_BACKSTACK_TAG).commit();
                return true;
            case R.id.action_login:
                Toast.makeText(App.getContext(), "Login", Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).addToBackStack(LoginFragment.LOGIN_FRAGMENT_BACKSTACK_TAG).commit();
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