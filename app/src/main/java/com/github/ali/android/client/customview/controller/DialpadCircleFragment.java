package com.github.ali.android.client.customview.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ali.android.client.customview.R;
import com.github.ali.android.client.customview.view.DialPadKey;
import com.github.ali.android.client.customview.view.PadLayout;

public class DialpadCircleFragment extends Fragment {

    private static final String TAG = "DialpadFragment";

    private PadLayout mPadLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        return inflater.inflate(R.layout.fragment_dialpad_circle, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);

        mPadLayout = (PadLayout) view.findViewById(R.id.padLayout);

        final DialPadKey mButton1 = (DialPadKey) view.findViewById(R.id.button1);
        final DialPadKey mButton2 = (DialPadKey) view.findViewById(R.id.button2);
        final DialPadKey mButton3 = (DialPadKey) view.findViewById(R.id.button3);
        final DialPadKey mButton4 = (DialPadKey) view.findViewById(R.id.button4);
        final DialPadKey mButton5 = (DialPadKey) view.findViewById(R.id.button5);
        final DialPadKey mButton6 = (DialPadKey) view.findViewById(R.id.button6);
        final DialPadKey mButton7 = (DialPadKey) view.findViewById(R.id.button7);
        final DialPadKey mButton8 = (DialPadKey) view.findViewById(R.id.button8);
        final DialPadKey mButton9 = (DialPadKey) view.findViewById(R.id.button9);
        final DialPadKey mButton10 = (DialPadKey) view.findViewById(R.id.button10);
        final DialPadKey mButton11 = (DialPadKey) view.findViewById(R.id.button11);
        final DialPadKey mButton12 = (DialPadKey) view.findViewById(R.id.button12);

        mPadLayout.post(new Runnable() {
            @Override
            public void run() {
                setConstraintFor(mButton1);
                setConstraintFor(mButton2);
                setConstraintFor(mButton3);
                setConstraintFor(mButton4);
                setConstraintFor(mButton5);
                setConstraintFor(mButton6);
                setConstraintFor(mButton7);
                setConstraintFor(mButton8);
                setConstraintFor(mButton9);
                setConstraintFor(mButton10);
                setConstraintFor(mButton11);
                setConstraintFor(mButton12);
            }
        });
    }

    private void setConstraintFor(View v) {
        final PadLayout.MarginLayoutParams params = (PadLayout.MarginLayoutParams) v.getLayoutParams();

        int columnWidth = (mPadLayout.getWidth() -
                mPadLayout.getPaddingLeft() -
                mPadLayout.getPaddingRight()) / mPadLayout.getColumnCount();

        int rowHeight = (mPadLayout.getHeight() -
                mPadLayout.getPaddingTop() -
                mPadLayout.getPaddingBottom()) / mPadLayout.getRowCount();

        if (rowHeight > columnWidth) {
            params.bottomMargin = (rowHeight - columnWidth  + params.leftMargin + params.rightMargin) / 2;
            params.topMargin = (rowHeight - columnWidth + params.leftMargin + params.rightMargin) / 2;
        } else if (columnWidth > rowHeight) {
            params.leftMargin = (columnWidth - rowHeight + params.topMargin + params.bottomMargin) / 2;
            params.rightMargin = (columnWidth - rowHeight + params.topMargin + params.bottomMargin) / 2;
        }
        v.setLayoutParams(params);
    }
}
