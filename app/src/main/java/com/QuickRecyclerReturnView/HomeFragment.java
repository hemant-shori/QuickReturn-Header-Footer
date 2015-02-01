package com.QuickRecyclerReturnView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quick_fragment, container, false);
        TextView mQuickReturnView = (TextView) view.findViewById(R.id.sticky);
        RecyclerView mListView = (RecyclerView) view.findViewById(R.id.mQuickRecyclerView);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListView.setHasFixedSize(true);
        //clip to padding is necessary to allow list cover the whole screen while scrolling
        mListView.setClipToPadding(false);
        //padding is necessary to show the upper items of the recycler view
        //here header_height is defined in dimen
        mListView.setPadding(10, getResources().getDimensionPixelSize(R.dimen.header_height) + getResources().getDimensionPixelSize(R.dimen.header_margin_top)+ getResources().getDimensionPixelSize(R.dimen.header_margin_top), 10, 0);
        mListView.setHasFixedSize(true);
        String[] array = new String[]{"List item 1", "List item 2", "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8", "List item 9", "List item 10", "List item 11", "List item 12", "List item 13", "List item 14", "List item 15", "List item 16", "List item 17", "List item 18", "List item 19", "List item 20"};
        mQuickReturnView.setText("Header");
        mListView.setAdapter(new RecyclerListAdapter(array));
        return view;
    }


}