package com.softwareengineering.smbook.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Irina on 11/26/2017.
 */

public class MovieScheduleFragment extends Fragment {

    public  static  final String MOVIE_SCHEDULE_FRAGMENT_BACKSTACK_TAG = "Movie_schedule_fragment_backstack_tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_schedule_fragment_layout, container, false);
        ButterKnife.bind(this, view);

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date day_after_tomorrow = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd MMM");

        String tomorrowAsString = dateFormat.format(tomorrow);
        String day_after_tomorrowAsString = dateFormat.format(day_after_tomorrow);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.dates_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("TODAY"));
        tabLayout.addTab(tabLayout.newTab().setText(tomorrowAsString));
        tabLayout.addTab(tabLayout.newTab().setText(day_after_tomorrowAsString));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return view;
    }

    @OnClick(R.id.back_arrow_image_view)
    public void onBackPressed(View view) {
        Toast.makeText(App.getContext(), "Back", Toast.LENGTH_LONG).show();
        getActivity().onBackPressed();
    }
}
