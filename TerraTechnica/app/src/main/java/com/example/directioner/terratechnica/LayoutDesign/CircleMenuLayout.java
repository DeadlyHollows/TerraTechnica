package com.example.directioner.terratechnica.LayoutDesign;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directioner.terratechnica.R;

/**
 * <pre>
 * @author zhy
 * http://blog.csdn.net/lmj623565791/article/details/43131133
 * </pre>
 */
public class CircleMenuLayout extends ViewGroup {

    private String direction;  // Can be clockwise ("clock"), anti-clockwise ("anticlock") or empty string ("")
    private int mRadius;
    /**
     * child item
     */
    private static final float RADIO_DEFAULT_CHILD_DIMENSION = 1 / 6f;
    /**
     * child
     */
    private float RADIO_DEFAULT_CENTERITEM_DIMENSION = 1 / 3f;
    /**
     * padding
     */
    private static final float RADIO_PADDING_LAYOUT = 1 / 12f;

    private static final int FLINGABLE_VALUE = 300;

    private static final int NOCLICK_VALUE = 3;


    private int mFlingableValue = FLINGABLE_VALUE;

    private float mPadding;

    private double mStartAngle = 0;

    private String[] mItemTexts;

    private int[] mItemImgs;


    private int mMenuItemCount;


    private float mTmpAngle;

    private long mDownTime;

    private boolean isFling;

    private int mMenuItemLayoutId = R.layout.circle_menu_item;

    public CircleMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // padding
        setPadding(0, 0, 0, 0);
    }

    /**
     * menu item
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int resWidth = 0;
        int resHeight = 0;

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode != MeasureSpec.EXACTLY
                || heightMode != MeasureSpec.EXACTLY) {
            resWidth = getSuggestedMinimumWidth();
            resWidth = resWidth == 0 ? getDefaultWidth() : resWidth;

            resHeight = getSuggestedMinimumHeight();
            resHeight = resHeight == 0 ? getDefaultWidth() : resHeight;
        } else {
            resWidth = resHeight = Math.min(width, height);
        }

        setMeasuredDimension(resWidth, resHeight);

        mRadius = Math.max(getMeasuredWidth(), getMeasuredHeight());

        // menu item
        final int count = getChildCount();
        // menu item
        int childSize = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
        // menu item
        int childMode = MeasureSpec.EXACTLY;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);

            if (child.getVisibility() == GONE) {
                continue;
            }

            // menu item, item
            int makeMeasureSpec = -1;

            if (child.getId() == R.id.id_circle_menu_item_center) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(
                        (int) (mRadius * RADIO_DEFAULT_CENTERITEM_DIMENSION),
                        childMode);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(childSize,
                        childMode);
            }
            child.measure(makeMeasureSpec, makeMeasureSpec);
        }

        mPadding = RADIO_PADDING_LAYOUT * mRadius;

    }

    /**
     * MenuItem
     *
     * @author zhy
     */
    public interface OnMenuItemClickListener {
        void itemClick(View view, int pos);

        void itemCenterClick(View view);
    }

    /**
     * MenuItem
     */
    private OnMenuItemClickListener mOnMenuItemClickListener;

    /**
     * MenuItem
     *
     * @param mOnMenuItemClickListener
     */
    public void setOnMenuItemClickListener(
            OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }

    /**
     * menu item
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutRadius = mRadius;

        // Laying out the child views
        final int childCount = getChildCount();

        int left, top;
        // menu item
        int cWidth = (int) (layoutRadius * RADIO_DEFAULT_CHILD_DIMENSION);

        // menu item
//        Toast.makeText(getContext(), "" + getChildCount(), Toast.LENGTH_SHORT).show();
//        float angleDelay = 360 / (getChildCount() - 1);

        float angleDelay = 360/7.0f; // For each item being displayed at a regular distance!
        // menuitem
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);

            if (child.getId() == R.id.id_circle_menu_item_center)
                continue;

            if (child.getVisibility() == GONE) {
                continue;
            }

            mStartAngle %= 360;

            // menu item
            float tmp = layoutRadius / 2f - cWidth / 2 - mPadding;

            // tmp cosa, menu item
            left = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.cos(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);
            // tmp sina, menu item
            top = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.sin(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);

            child.layout(left, top, left + cWidth, top + cWidth);
            // 叠加尺寸
            mStartAngle += angleDelay;
        }

        // view, onclick
        View cView = findViewById(R.id.id_circle_menu_item_center);
        if (cView != null) {
            cView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mOnMenuItemClickListener != null) {
                        mOnMenuItemClickListener.itemCenterClick(v);
                    }
                }
            });
            // center item
            int cl = layoutRadius / 2 - cView.getMeasuredWidth() / 2;
            int cr = cl + cView.getMeasuredWidth();
            cView.layout(cl, cl, cr, cr);
        }

    }

    private float mLastX;
    private float mLastY;

    private AutoFlingRunnable mFlingRunnable;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // Log.e("TAG", "x = " + x + " , y = " + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                mLastX = x;
                mLastY = y;
                mDownTime = System.currentTimeMillis();
                mTmpAngle = 0;

                if (isFling) {
                    removeCallbacks(mFlingRunnable);
                    isFling = false;
                    return true;
                }

                break;
            case MotionEvent.ACTION_MOVE:

                float start = getAngle(mLastX, mLastY);
                float end = getAngle(x, y);

//                Toast.makeText(getContext(), "start = " + start + " , end =" + end, Toast.LENGTH_SHORT).show();

                // Log.e("TAG", "start = " + start + " , end =" + end);
                // end-start
                if (getQuadrant(x, y) == 1 || getQuadrant(x, y) == 4) {
                    mStartAngle += end - start;
                    mTmpAngle += end - start;
//                    Toast.makeText(getContext(), "Rotation: Clockwise", Toast.LENGTH_SHORT).show();
                } else {
                    mStartAngle += start - end;
                    mTmpAngle += start - end;
//                    Toast.makeText(getContext(), "Rotation: Anti-Clockwise", Toast.LENGTH_SHORT).show();
                }
                requestLayout();

                mLastX = x;
                mLastY = y;

                break;
            case MotionEvent.ACTION_UP:

                float anglePerSecond = mTmpAngle * 1000
                        / (System.currentTimeMillis() - mDownTime);

                // Log.e("TAG", anglePrMillionSecond + " , mTmpAngel = " +
                // mTmpAngle);

                if (Math.abs(anglePerSecond) > mFlingableValue && !isFling) {
                    // post
                    post(mFlingRunnable = new AutoFlingRunnable(anglePerSecond));

                    return true;
                }

                // NOCLICK_VALUE
                if (Math.abs(mTmpAngle) > NOCLICK_VALUE) {
                    return true;
                }

                break;
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * action_down, true
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    /**
     * @param xTouch
     * @param yTouch
     * @return
     */
    private float getAngle(float xTouch, float yTouch) {
        double x = xTouch - (mRadius / 2d);
        double y = yTouch - (mRadius / 2d);
        return (float) (Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
    }

    /**
     * @param x
     * @param y
     * @return
     */
    private int getQuadrant(float x, float y) {
        int tmpX = (int) (x - mRadius / 2);
        int tmpY = (int) (y - mRadius / 2);
        if (tmpX >= 0) {
            return tmpY >= 0 ? 4 : 1;
        } else {
            return tmpY >= 0 ? 3 : 2;
        }

    }

    /**
     * @param resIds
     */
    public void setMenuItemIconsAndTexts(int[] resIds, String[] texts) {
        mItemImgs = resIds;
        mItemTexts = texts;

        if (resIds == null && texts == null) {
            throw new IllegalArgumentException("Illegal Argument!");
        }

        // mMenuCount
        mMenuItemCount = resIds == null ? texts.length : resIds.length;

        if (resIds != null && texts != null) {
            mMenuItemCount = Math.min(resIds.length, texts.length);
        }

        addMenuItems();

    }

    /**
     * MenuItem, setMenuItemIconsAndTexts
     *
     * @param mMenuItemLayoutId
     */
    public void setMenuItemLayoutId(int mMenuItemLayoutId) {
        this.mMenuItemLayoutId = mMenuItemLayoutId;
    }

    private void addMenuItems() {
        LayoutInflater mInflater = LayoutInflater.from(getContext());

        /**
         * view
         */
        for (int i = 0; i < mMenuItemCount; i++) {
            final int j = i;
            View view = mInflater.inflate(mMenuItemLayoutId, this, false);
            ImageView iv = (ImageView) view
                    .findViewById(R.id.id_circle_menu_item_image);
            TextView tv = (TextView) view
                    .findViewById(R.id.id_circle_menu_item_text);

            if (iv != null) {
                iv.setVisibility(View.VISIBLE);
                iv.setImageResource(mItemImgs[i]);
                iv.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mOnMenuItemClickListener != null) {
                            mOnMenuItemClickListener.itemClick(v, j);
                        }
                    }
                });
            }
            if (tv != null) {
                tv.setVisibility(View.VISIBLE);
                tv.setText(mItemTexts[i]);
            }

            // view
            addView(view);
        }
    }

    /**
     * @param mFlingableValue
     */
    public void setFlingableValue(int mFlingableValue) {
        this.mFlingableValue = mFlingableValue;
    }

    /**
     * @param mPadding
     */
    public void setPadding(float mPadding) {
        this.mPadding = mPadding;
    }

    /**
     * @return
     */
    private int getDefaultWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return Math.min(outMetrics.widthPixels, outMetrics.heightPixels);
    }

    /**
     * @author zhy
     */
    private class AutoFlingRunnable implements Runnable {

        private float angelPerSecond;

        public AutoFlingRunnable(float velocity) {
            this.angelPerSecond = velocity;
        }

        public void run() {
            direction = "";
            if ((int) Math.abs(angelPerSecond) < 20) {
                isFling = false;
                direction = "";
                return;
            }
            isFling = true;
            // mStartAngle
            if(angelPerSecond>=20) {
//                Toast.makeText(getContext(), "Clockwise", Toast.LENGTH_SHORT).show();
                Log.v("TAG", "Clockwise");
                direction = "clock";
            }
            else if(angelPerSecond<=-20) {
//                Toast.makeText(getContext(), "Anti-Clockwise", Toast.LENGTH_SHORT).show();
                Log.v("TAG", "Anti-Clockwise");
                direction = "anticlock";
            }
            glow();
            mStartAngle += (angelPerSecond / 30);
            angelPerSecond /= 1.0666F;
            postDelayed(this, 30);
            requestLayout();
        }
    }

    private void glow() {
//        Toast.makeText(getContext(), "" + findViewById(R.id.id_menulayout).getAlpha(), Toast.LENGTH_SHORT).show();
        switch (direction) {
            case "clock":
                // Increase the color intensity here ...
                ((CircleMenuLayout) findViewById(R.id.id_menulayout)).setAlpha((getAlpha()+0.1f)<1?(getAlpha()+0.1f):1);
                break;
            case "anticlock":
                // Decrease the color intensity here ...
                ((CircleMenuLayout) findViewById(R.id.id_menulayout)).setAlpha((getAlpha()-0.1f)>0.6f?(getAlpha()-0.1f):0.6f);
                break;
        }
    }

}