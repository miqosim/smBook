package com.softwareengineering.smbook.adapters;

/**
 * Created by Irina on 11/15/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;
import com.softwareengineering.smbook.fragments.CinemaAboutFragment;
import com.softwareengineering.smbook.fragments.CinemaScheduleFragment;

import butterknife.ButterKnife;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.MyViewHolder> {
    private String[] mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view;
        public TextView cinema_name_text_view;
        public ImageView cinema_main_image;
        public TextView cinema_address_text_view;
        public TextView cinema_about_text_view;
        public TextView cinema_schedule_text_view;


        public MyViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            card_view = (CardView) v.findViewById(R.id.cinema_card_view);
            cinema_name_text_view = (TextView) v.findViewById(R.id.cinema_name_text_view);
            cinema_main_image = (ImageView) v.findViewById(R.id.cinema_main_image);
            cinema_address_text_view = (TextView) v.findViewById(R.id.cinema_address_text_view);
            cinema_about_text_view =  (TextView) v.findViewById(R.id.cinema_about_text_view);
            cinema_schedule_text_view =  (TextView) v.findViewById(R.id.cinema_schedule_text_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CinemaAdapter(Context context,String[] myDataset) {
        mContext=context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CinemaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cinema_page_fragment_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);

                return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.cinema_name_text_view.setText(mDataset[position]);
        holder.cinema_address_text_view.setText(mDataset[position]);
        holder.cinema_main_image.setImageDrawable(App.getContext().getResources().getDrawable(R.drawable.ic_launcher));
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = mDataset[position];
                Log.d("CardView", "CardView Clicked: " + currentValue);
            }
        });
        holder.cinema_about_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CinemaAboutFragment()).addToBackStack(null).commit();
            }
        });
        holder.cinema_schedule_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CinemaScheduleFragment()).addToBackStack(null).commit();
                Toast.makeText(App.getContext(), "Cinema Schedule", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
