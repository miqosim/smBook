package com.softwareengineering.smbook.activities;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.fragments.MyFragment;
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
//            MyFragment myf = new MyFragment();
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.add(R.id.frame, myf);
//            transaction.commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyFragment()).addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyFragment()).addToBackStack(null).commit();
    }

}
