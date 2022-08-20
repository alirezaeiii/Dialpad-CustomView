package com.sample.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DialPadActivity extends AppCompatActivity {

    static final String DIALPAD_SORT = "dialpad";
    static final int CIRCLE = 0;
    static final int UNBOUNDED_RIPPLE = 1;
    static final int BORDERLINE = 2;
    static final int ANIMATION = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                case ANIMATION:
                    fragment = new DialPadAnimationFragment();
                    break;

                default:
                    throw new IllegalStateException("Fragment is not initialized.");
            }
            fragmentManager.beginTransaction().replace(
                    R.id.content_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_fragment);
        if (!(fragment instanceof IOnBackPressed) ||
                !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }
}
