package com.iak3.vina.finalproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.iak3.vina.finalproject.R;

/**
 * Created by vwinata on 9/2/2017.
 */

public class Generator {

    public static View getReview(Context context, String author, String description) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_review, null);
        TextView tvAuthor = (TextView) view.findViewById(R.id.tv_author);
        tvAuthor.setText(author);
        TextView tvDescription = (TextView) view.findViewById(R.id.tv_description);
        tvDescription.setText(description);
        return view;
    }
}