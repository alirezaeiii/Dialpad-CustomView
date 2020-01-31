package com.sample.android.padlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DialPadKey extends LinearLayout {

    private static final boolean DEFAULT_LETTER_GONE = true;
    private static final boolean DEFAULT_EQUAL_SPACING = true;

    private boolean mEqualSpacing;

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
            mEqualSpacing = a.getBoolean(R.styleable.DialPadKey_equalSpacing, DEFAULT_EQUAL_SPACING);
        } finally {
            a.recycle();
        }
        inflate(getContext(), R.layout.dialpad_key, this);
        ((DialpadTextView) findViewById(R.id.dialpad_key_number)).setText(numberText);
        final TextView subTextView = findViewById(R.id.dialpad_key_letters);
        if (letterGone && TextUtils.isEmpty(letterText)) {
            subTextView.setVisibility(GONE);
        } else {
            subTextView.setText(letterText);
        }
    }

    public boolean isEqualSpacing() {
        return mEqualSpacing;
    }
}
