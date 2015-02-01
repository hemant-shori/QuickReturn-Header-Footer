package com.QuickRecyclerReturnView;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomFragment extends Fragment {

    private RecyclerView mListView;
    private TextView mQuickReturnView;
    private int mFinalScrolled = 0;
    private int mQuickFieldHeight = 120;
    private boolean hidden = false;
    private TranslateAnimation anim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quick_fragment, container, false);
        mQuickReturnView = (TextView) view.findViewById(R.id.sticky);
        mQuickFieldHeight=getResources().getDimensionPixelSize(R.dimen.footer_height);
        FrameLayout.LayoutParams params= new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mQuickFieldHeight);
        params.gravity=Gravity.BOTTOM;
        mQuickReturnView.setLayoutParams(params);
        mQuickReturnView.setText("Animated Bottom");

        mListView = (RecyclerView) view.findViewById(R.id.mQuickRecyclerView);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListView.setHasFixedSize(true);
        //clip to padding is necessary to allow list cover the whole screen while scrolling
        mListView.setClipToPadding(false);
        //padding is necessary to show the upper items of the recycler view
        //here header_height is defined in dimen
        mListView.setPadding(10,0, 10, 0);
        mListView.setHasFixedSize(true);
        String[] array = new String[]{"List item 1", "List item 2", "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8", "List item 9", "List item 10", "List item 11", "List item 12", "List item 13", "List item 14", "List item 15", "List item 16", "List item 17", "List item 18", "List item 19", "List item 20"};
        mListView.setAdapter(new RecyclerListAdapter(array));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mListView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    /** this can be used if the build is below honeycomb **/
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
                        if (hidden) {
                            return;
                        }
                        anim = new TranslateAnimation(0, 0, 0, mQuickFieldHeight);
                        anim.setFillAfter(true);
                        anim.setDuration(250);
                        mQuickReturnView.startAnimation(anim);
                        hidden = true;
                    } else {
                        // And for all other devices
                        if (mFinalScrolled >= mQuickFieldHeight)
                            return;

                        if (dy > mQuickFieldHeight) {
                            mFinalScrolled = mQuickFieldHeight;
                        } else {
                            mFinalScrolled += dy;
                        }
                        if (mFinalScrolled >= mQuickFieldHeight) {
                            mFinalScrolled = mQuickFieldHeight;
                        }
                        mQuickReturnView.setTranslationY(mFinalScrolled);
                    }
                } else if (dy < 0) {

                    /** this can be used if the build is below honeycomb **/
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
                        if (!hidden)
                            return;
                        anim = new TranslateAnimation(0, 0, mQuickFieldHeight,
                                0);
                        anim.setFillAfter(true);
                        anim.setDuration(250);
                        mQuickReturnView.startAnimation(anim);
                        hidden = false;
                    } else {
                        //For all other devices
                        if (mFinalScrolled <= 0)
                            return;

                        if (dy < -mQuickFieldHeight) {
                            mFinalScrolled = 0;
                        } else {
                            mFinalScrolled += dy;
                        }

                        if (mFinalScrolled <= 0) {
                            mFinalScrolled = 0;
                        }
                        mQuickReturnView.setTranslationY(mFinalScrolled);
                    }
                }
            }
        });


    }
}