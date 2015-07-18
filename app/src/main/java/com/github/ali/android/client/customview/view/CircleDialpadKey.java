package com.github.ali.android.client.customview.view;

import android.content.Context;
import android.util.AttributeSet;

public class CircleDialpadKey extends DialPadKey {

    public CircleDialpadKey(Context context) {
        this(context, null);
    }

    public CircleDialpadKey(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleDialpadKey(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        final PadLayout.MarginLayoutParams params = (PadLayout.MarginLayoutParams) getLayoutParams();

        final PadLayout mPadLayout = (PadLayout) getParent();

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
        setLayoutParams(params);

        super.onLayout(changed, left, top, right, bottom);
    }
}
