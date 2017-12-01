package com.softwareengineering.smbook.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.softwareengineering.smbook.R;
import com.softwareengineering.smbook.activities.MainActivity;

import java.util.Locale;

/**
 * Created by billy on 11/11/17.
 */

public class WelcomeScreenFragment extends Fragment {

    public static final String APP_LANGUAGE = "smBook_language";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.welcome_screen_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button armenianLanguageButton = view.findViewById(R.id.armenian_language_btn);
        Button russianLanguageButton = view.findViewById(R.id.russian_language_btn);
        Button englishLanguageButton = view.findViewById(R.id.english_language_btn);

        armenianLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString(APP_LANGUAGE, "hy").apply();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean(MainActivity.IS_FIRST_LAUNCH, false).apply();
                setLangRecreate("hy");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TabFragment()).commit();
            }
        });

        russianLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString(APP_LANGUAGE, "ru").apply();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean(MainActivity.IS_FIRST_LAUNCH, false).apply();
                setLangRecreate("ru");
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TabFragment()).commit();

            }
        });

        englishLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean(MainActivity.IS_FIRST_LAUNCH, false).apply();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TabFragment()).commit();

            }
        });
    }

    public void setLangRecreate(String language) {
        Configuration config = getActivity().getResources().getConfiguration();
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
        getActivity().recreate();
    }
}
