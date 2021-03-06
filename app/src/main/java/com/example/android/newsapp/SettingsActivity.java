package com.example.android.newsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by karenulmer on 7/2/2017.
 */


  public class SettingsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
        }

        public static class NewsPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {


            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.xml.settings_main);


                Preference list = findPreference(getString(R.string.listSize));
                bindPreferenceSummaryToValue(list);

                Preference section = findPreference(getString(R.string.section_title));
                bindPreferenceSummaryToValue(section);
            }

            private void bindPreferenceSummaryToValue(Preference preference) {
                preference.setOnPreferenceChangeListener(this);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
                String preferenceString = preferences.getString(preference.getKey(), "");
                onPreferenceChange(preference, preferenceString);
            }

            @Override
            public boolean onPreferenceChange (Preference preference, Object value){
                String stringValue = value.toString();
                if (preference instanceof ListPreference) {
                    ListPreference listPreference = (ListPreference) preference;
                    int prefIndex = listPreference.findIndexOfValue(stringValue);
                    if (prefIndex >= 0) {
                        CharSequence[] labels = listPreference.getEntries();
                        preference.setSummary(labels[prefIndex]);
                    }
                } else {
                    preference.setSummary(stringValue);
                }
                return true;
            }


        }
    }


