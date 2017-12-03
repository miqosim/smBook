package com.softwareengineering.smbook.activities;

import android.content.ClipData;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.fragments.TabFragment;
import com.softwareengineering.smbook.fragments.WelcomeScreenFragment;

import butterknife.ButterKnife;
//import com.softwareengineering.smbook.fragments.WelcomeScreenFragment;

public class MainActivity extends AppCompatActivity {
    public static final String IS_FIRST_LAUNCH = "is_first_launch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean(IS_FIRST_LAUNCH, true)){
            PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(IS_FIRST_LAUNCH, false).apply();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WelcomeScreenFragment()).addToBackStack(null).commit();
        }
        else {
//
//            TabFragment myf = new TabFragment();
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.add(R.id.frame, myf);
//            transaction.commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TabFragment()).addToBackStack(TabFragment.TABFRAGMENT_BACKSTACK_TAG).commit();
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        int index = getSupportFragmentManager().getBackStackEntryCount();
        FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index-1);
        String tag = backEntry.getName();

        if(tag.equals(TabFragment.TABFRAGMENT_BACKSTACK_TAG)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TabFragment()).addToBackStack(TabFragment.TABFRAGMENT_BACKSTACK_TAG).commit();
        }
    }

}
