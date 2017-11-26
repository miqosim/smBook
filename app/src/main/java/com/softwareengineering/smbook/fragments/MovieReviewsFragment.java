package com.softwareengineering.smbook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Irina on 11/26/2017.
 */

public class MovieReviewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_schedule_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.back_arrow_image_view)
    public void onBackPressed(View view) {
        Toast.makeText(App.getContext(), "Back", Toast.LENGTH_LONG).show();
        getActivity().onBackPressed();
    }
}
