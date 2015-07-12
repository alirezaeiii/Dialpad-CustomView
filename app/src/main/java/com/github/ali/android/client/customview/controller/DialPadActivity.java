package com.github.ali.android.client.customview.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.ali.android.client.customview.R;

public class DialPadActivity extends AppCompatActivity {

    private static final String TAG = "DialPadActivity";

    static final String DIALPAD_SORT = "dialpad";
    static final int CIRCLE = 0;
    static final int UNBOUNDED_RIPPLE = 1;
    static final int BORDERLINE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialpad);

        if (savedInstanceState == null) {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            final int dialpadSort = getIntent().getIntExtra(DIALPAD_SORT, CIRCLE);
            final Fragment fragment;
            switch (dialpadSort) {
                case CIRCLE:
                    fragment = new DialpadCircleFragment();
                    break;

                case UNBOUNDED_RIPPLE:
                    fragment = new DialpadRippleFragment();
                    break;

                case BORDERLINE:
                    fragment = new DialpadBorderFragment();
                    break;

                default:
                    throw new IllegalStateException("Fragment is not initialized.");
            }
            fragmentManager.beginTransaction().replace(
                    R.id.content_fragment, fragment)
                    .commit();
        }
    }
}
