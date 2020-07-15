/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package com.sample.android.padlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * This is a custom text view intended only for rendering the numerals (and star and pound) on the
 * dialpad. TextView has built in top/bottom padding to help account for ascenders/descenders.
 *
 * Since vertical space is at a premium on the dialpad, particularly if the font size is scaled to
 * a larger default, for the dialpad we use this class to more precisely render characters according
 * to the precise amount of space they need.
 */
public class DialpadTextView extends TextView {
    private Rect mTextBounds = new Rect();
    private String mTextStr;

    public DialpadTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        canvas.drawText(mTextStr, -mTextBounds.left, -mTextBounds.top, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mTextStr = getText().toString();
        getPaint().getTextBounds(mTextStr, 0, mTextStr.length(), mTextBounds);
        int width = resolveSize(mTextBounds.width(), widthMeasureSpec);
        int height = resolveSize(mTextBounds.height(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}