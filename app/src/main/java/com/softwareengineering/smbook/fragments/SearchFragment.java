package com.softwareengineering.smbook.fragments;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;
import com.softwareengineering.smbook.adapters.MovieAdapter;
import com.softwareengineering.smbook.adapters.SearchMovieAdapter;
import com.softwareengineering.smbook.condition.Condition;
import com.softwareengineering.smbook.controller.Controller;
import com.softwareengineering.smbook.pojo.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends Fragment {
    public  static  final String SEARCH_FRAGMENT_BACKSTACK_TAG = "Search_fragment_backstack_tag";
    ArrayList<Movie> searchResults;
    TabLayout tabLayout;
    int pos;
//    @BindView(R.id.search_et) EditText search_et;

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
        tabLayout.addTab(tabLayout.newTab().setText(R.string.by_movie_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.by_director));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

       final RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_search_recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pos = tab.getPosition();
                EditText search_et = (EditText)getActivity().findViewById(R.id.search_et);
                if (pos == 0) {
                    Toast.makeText(App.getContext(), "Load search by title", Toast.LENGTH_LONG).show();
                    Condition searchByTitleCondition = new Condition();
                    searchByTitleCondition.setMovieName(search_et.getText().toString());
                    searchResults = Controller.searchMovie(searchByTitleCondition);
                } else {
                    Toast.makeText(App.getContext(), "Load search by director", Toast.LENGTH_LONG).show();
                    Condition searchByDirectorCondition = new Condition();
                    searchByDirectorCondition.setMovieDirector(search_et.getText().toString());
                    searchResults = Controller.searchMovie(searchByDirectorCondition);
                }

                SearchMovieAdapter adapter = new SearchMovieAdapter(getActivity(),searchResults);
                rv.setAdapter(adapter);
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

//    @OnClick(R.id.ok_btn)
//    public void ok_btn_pressed(View view) {
//        EditText search_et = (EditText)getActivity().findViewById(R.id.search_et);
//        Toast.makeText(App.getContext(), search_et.getText().toString(), Toast.LENGTH_LONG).show();
//    }

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
