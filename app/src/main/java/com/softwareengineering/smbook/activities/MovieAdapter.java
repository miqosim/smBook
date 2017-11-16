package com.softwareengineering.smbook.activities;

/**
 * Created by Irina on 11/15/2017.
 */

import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softwareengineering.smbook.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private String[] mDataset;

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
    public MovieAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
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
        holder.mMovieTitleTextView.setText(mDataset[position]);
        holder.movie_poster_image.setImageDrawable(App.getContext().getResources().getDrawable(R.drawable.ic_launcher));
        holder.movie_rating_text_view.setText(mDataset[position]);
        holder.movie_share_image_button.setImageDrawable(App.getContext().getResources().getDrawable(R.drawable.ic_launcher));
        holder.movie_about_text_view.setText(mDataset[position]);
        holder.movie_reviews_text_view.setText(mDataset[position]);
        holder.movie_schedule_text_view.setText(mDataset[position]);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = mDataset[position];
                Log.d("CardView", "CardView Clicked: " + currentValue);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
