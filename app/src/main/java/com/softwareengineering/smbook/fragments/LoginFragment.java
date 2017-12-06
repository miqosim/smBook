package com.softwareengineering.smbook.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.App;
import com.softwareengineering.smbook.localDbConnection.DbOpenHelper;
import com.softwareengineering.smbook.pojo.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {
    public  static  final String LOGIN_FRAGMENT_BACKSTACK_TAG = "Login_fragment_backstack_tag";
    @BindView(R.id.user_text_view) TextView user_text_view;
    @BindView(R.id.user_et) TextView user_et;
    @BindView(R.id.password_text_view) TextView password_text_view;
    @BindView(R.id.password_et) TextView password_et;
    @BindView(R.id.button) TextView button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        setHasOptionsMenu(true);



        return view;
    }

    @OnClick(R.id.button)
    public void loginButtonPressed(View view) {

        //TODO: object user, set username and password, pass to DbOpenHelper
        String username = user_et.getText().toString();
        String password = password_et.getText().toString();
        User user = new User(username, password);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(getActivity());
        dbOpenHelper.addUserCredentials(user);
        Toast.makeText(App.getContext(), "Login", Toast.LENGTH_LONG).show();
    }

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
