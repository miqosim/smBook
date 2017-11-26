package com.softwareengineering.smbook.fragments;

/**
 * Created by Irina on 11/15/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.adapters.CinemaAdapter;
import com.softwareengineering.smbook.adapters.MovieAdapter;

import butterknife.ButterKnife;

public class RVFragment extends Fragment {

    public RVFragment() {
        // Required empty public constructor
    }

    public static RVFragment newInstance(int someInt) {
        RVFragment rvFragment = new RVFragment();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        rvFragment.setArguments(args);

        return rvFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.rv_fragment, container, false);
        ButterKnife.bind(this, rootView);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        int tab = getArguments().getInt("someInt", 0);
        if (tab == 0) {
            MovieAdapter adapter = new MovieAdapter(getActivity(),new String[]{"test one", "test two", "test three"});
            rv.setAdapter(adapter);
        } else if (tab == 1) {
            CinemaAdapter adapter = new CinemaAdapter(getActivity(),new String[]{"test one", "test two", "test three"});
            rv.setAdapter(adapter);
        }


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
