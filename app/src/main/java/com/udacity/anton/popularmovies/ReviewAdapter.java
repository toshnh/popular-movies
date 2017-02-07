package com.udacity.anton.popularmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.udacity.anton.popularmovies.data.ReviewObject;

/**
 * Created by anton on 07/02/17.
 */

class ReviewAdapter extends ArrayAdapter<ReviewObject> {

    private ReviewObject[] reviews;

    public ReviewAdapter(Context context, ReviewObject[] reviews) {
        super(context, 0, reviews);
        this.reviews=reviews;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReviewObject review=getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.review_list_item, parent, false);
        }

        TextView textView= (TextView) convertView.findViewById(R.id.review_item_text);
        if (review != null) {
            textView.setText(review.getReviewAuthor());
        }

        return convertView;
    }
}