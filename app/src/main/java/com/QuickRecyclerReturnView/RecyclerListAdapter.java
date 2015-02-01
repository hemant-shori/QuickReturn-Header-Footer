package com.QuickRecyclerReturnView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerListAdapter extends
        RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the type of views that you are using
    // (custom view holder)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        View convertView;

        public ViewHolder(View rowView) {
            super(rowView);
            TextView textView = (TextView) rowView
                    .findViewById(android.R.id.text1);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            mTextView = textView;
            convertView = rowView;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerListAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(
                android.R.layout.simple_list_item_1, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);

    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your data set at this position
        // - replace the contents of the view with that element
        holder.mTextView.setBackgroundColor(Color.argb(255, 190, 190, 190));
        holder.mTextView.setPadding(0, 15, 0, 15);
        holder.mTextView.setTextColor(Color.BLACK);
        holder.mTextView.setText(Html.fromHtml(mDataset[position]));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerListAdapter(String[] myDataset) {
        this.mDataset = myDataset;
    }

}