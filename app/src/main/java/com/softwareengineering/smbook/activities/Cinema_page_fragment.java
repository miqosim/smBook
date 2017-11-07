package com.softwareengineering.smbook.activities;

/**
 * Created by Irina on 11/7/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareengineering.smbook.R;

public class Cinema_page_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cinam_page_fragment_layout, container, false);
    }
}