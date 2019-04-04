package com.github.ali.android.client.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.ali.android.client.customview.R;
import com.sample.android.padlayout.DialpadTextView;

public class DialPadKey extends LinearLayout {

    private static final boolean DEFAULT_LETTER_GONE = true;

    public DialPadKey(Context context) {
        this(context, null);
    }

    public DialPadKey(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialPadKey(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        setLayoutParams(params);
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.DialPadKey,
                0,
                defStyleAttr);

        String numberText, letterText;
        boolean letterGone;
        try {
            numberText = a.getString(R.styleable.DialPadKey_numberText);
            letterText = a.getString(R.styleable.DialPadKey_letterText);
            letterGone = a.getBoolean(R.styleable.DialPadKey_letterGone, DEFAULT_LETTER_GONE);
        } finally {
            a.recycle();
        }
        inflate(getContext(), R.layout.dialpad_key, this);
        ((DialpadTextView) findViewById(R.id.dialpad_key_number)).setText(numberText);
        final TextView subTextView = (TextView) findViewById(R.id.dialpad_key_letters);
        if (letterGone && TextUtils.isEmpty(letterText)) {
            subTextView.setVisibility(GONE);
        } else {
            subTextView.setText(letterText);
        }
    }
}
