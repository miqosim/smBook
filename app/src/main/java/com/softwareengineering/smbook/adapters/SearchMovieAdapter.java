package com.softwareengineering.smbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;
import com.softwareengineering.smbook.controller.Controller;
import com.softwareengineering.smbook.fragments.MovieAboutFragment;
import com.softwareengineering.smbook.fragments.MovieReviewsFragment;
import com.softwareengineering.smbook.fragments.MovieScheduleFragment;
import com.softwareengineering.smbook.pojo.Movie;

import java.util.ArrayList;


public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList<Movie> searchResults;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mMovieTitleTextView;
        public AppCompatImageView movie_poster_image;
        public TextView movie_rating_text_view;
        public AppCompatImageButton movie_share_image_button;
        public TextView movie_about_text_view;
        public TextView movie_reviews_text_view;
        public TextView movie_schedule_text_view;



        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.movie_card_view);
            mMovieTitleTextView = (TextView) v.findViewById(R.id.movie_title_text_view);
            movie_poster_image = (AppCompatImageView) v.findViewById(R.id.movie_poster_image);
            movie_rating_text_view = (TextView) v.findViewById(R.id.movie_rating_text_view);
            movie_share_image_button = (AppCompatImageButton) v.findViewById(R.id.movie_share_image_button);
            movie_about_text_view = (TextView)v.findViewById(R.id.movie_about_text_view);
            movie_reviews_text_view = (TextView) v.findViewById(R.id.movie_reviews_text_view);
            movie_schedule_text_view = (TextView) v.findViewById(R.id.movie_schedule_text_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SearchMovieAdapter(Context context, ArrayList<Movie> searchResults) {
        mContext=context;
        this.searchResults = searchResults;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SearchMovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_page_fragment_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //here I have some default values just to see how it will look like
        holder.movie_poster_image.setImageDrawable(App.getContext().getResources().getDrawable(R.drawable.poster_test));
        holder.movie_share_image_button.setImageDrawable(App.getContext().getResources().getDrawable(R.drawable.ic_share_black_24dp));
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = searchResults.get(position).getName();
                Log.d("CardView", "CardView Clicked: " + currentValue);
            }
        });
        holder.movie_share_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        holder.movie_about_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieAboutFragment()).addToBackStack(MovieAboutFragment.MOVIE_ABOUT_FRAGMENT_BACKSTACK_TAG).commit();
            }
        });
        holder.movie_reviews_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieReviewsFragment()).addToBackStack(MovieReviewsFragment.MOVIE_REVIEWS_FRAGMENT_BACKSTACK_TAG).commit();
            }
        });
        holder.movie_schedule_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieScheduleFragment()).addToBackStack(MovieScheduleFragment.MOVIE_SCHEDULE_FRAGMENT_BACKSTACK_TAG).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }
}


