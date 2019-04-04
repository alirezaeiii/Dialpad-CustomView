package com.sample.android.padlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class PadLayout extends ViewGroup {

    private static final int DEFAULT_COLUMN_COUNT = 3;
    private static final int DEFAULT_ROW_COUNT = 4;
    private static final int DEFAULT_STROKE_WIDTH = 0;
    private static final int DEFAULT_COLOR = Color.TRANSPARENT;
    private static final boolean DEFAULT_EQUAL_SPACING = false;

    private int mColumnCount, mRowCount;
    private int mStrokeWidth, mStrokeColor;
    private boolean mEqualSpacing;

    public PadLayout(Context context) {
        this(context, null);
    }

    public PadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BoxGridLayout,
                0,
                defStyleAttr);

        try {
            mStrokeWidth = a.getDimensionPixelSize(R.styleable.BoxGridLayout_separatorWidth, DEFAULT_STROKE_WIDTH);
            mStrokeColor = a.getColor(R.styleable.BoxGridLayout_separatorColor, DEFAULT_COLOR);
            mColumnCount = a.getInteger(R.styleable.BoxGridLayout_numColumns, DEFAULT_COLUMN_COUNT);
            mRowCount = a.getInteger(R.styleable.BoxGridLayout_numRows, DEFAULT_ROW_COUNT);
            mEqualSpacing = a.getBoolean(R.styleable.BoxGridLayout_equalSpacing, DEFAULT_EQUAL_SPACING);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        final int columnWidth = (right - left - paddingLeft - paddingRight) / mColumnCount;
        final int rowHeight = (bottom - top - paddingTop - paddingBottom) / mRowCount;

        int rowIndex, columnIndex;
        for (int i = 0; i < getChildCount(); i++) {
            final View childView = getChildAt(i);

            final MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

            columnIndex = i % mColumnCount;
            rowIndex = i / mColumnCount;

            if (mEqualSpacing) {
                if (rowHeight > columnWidth) {
                    lp.topMargin = lp.bottomMargin = (rowHeight - columnWidth + lp.leftMargin + lp.rightMargin) / 2;
                } else if (columnWidth > rowHeight) {
                    lp.leftMargin = lp.rightMargin = (columnWidth - rowHeight + lp.topMargin + lp.bottomMargin) / 2;
                }
            }

            final int childLeft = paddingLeft + columnIndex * columnWidth + lp.leftMargin;
            final int childTop = paddingTop + rowIndex * rowHeight + lp.topMargin;


            if (columnWidth != childView.getMeasuredWidth() ||
                    rowHeight != childView.getMeasuredHeight()) {
                childView.measure(
                        MeasureSpec.makeMeasureSpec(columnWidth, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(rowHeight, MeasureSpec.EXACTLY));
            }

            childView.layout(childLeft,
                    childTop,
                    childLeft + columnWidth - lp.leftMargin - lp.rightMargin,
                    childTop + rowHeight - lp.topMargin - lp.bottomMargin);
        }
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);

        final int width = getWidth();
        final int height = getHeight();

        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(mStrokeColor);
        paint.setStrokeWidth(mStrokeWidth);

        for (int i = paddingLeft; i <= width - paddingRight; i += (width - paddingLeft - paddingRight) / mColumnCount) {
            canvas.drawLine(i, paddingTop, i, height - paddingBottom, paint);
        }
        for (int i = paddingTop; i <= height - paddingBottom; i += (height - paddingTop - paddingBottom) / mRowCount) {
            canvas.drawLine(paddingLeft, i, width - paddingRight, i, paint);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
