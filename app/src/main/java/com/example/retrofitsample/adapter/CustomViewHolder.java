package com.example.retrofitsample.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitsample.R;

/**
 * Created by dwp on 2021-01-21.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    public final View mView;

    TextView txtTitle;
    ImageView coverImage;

    CustomViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        txtTitle = mView.findViewById(R.id.coverTitle);
        coverImage = mView.findViewById(R.id.coverImage);
    }
}
