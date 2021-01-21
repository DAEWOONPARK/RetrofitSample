package com.example.retrofitsample.viewmodel;

import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.example.retrofitsample.R;
import com.example.retrofitsample.adapter.MyAdapter;
import com.example.retrofitsample.model.RetroPhoto;
import com.google.gson.annotations.SerializedName;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwp on 2021-01-21.
 */
public class MyViewModel {
    List<RetroPhoto> dataList;
    MyAdapter adapter;

    public MyViewModel() {
        if(dataList == null) {
            dataList = new ArrayList<>();
        }

        if(adapter == null) {
            adapter = new MyAdapter(this);
        }
    }

    public void onCreate() {
        adapter.notifyDataSetChanged();
    }

    public void setDataList(List<RetroPhoto> dataList) {
        this.dataList = dataList;
    }

    public MyAdapter getAdapter() {
        return adapter;
    }

    public List<RetroPhoto> getDateList() {
        return dataList;
    }

    public String getTitle(int position) {
        return dataList.get(position).getTitle();
    }

    public String getThumbnailUrl(int position) {
        return dataList.get(position).getThumbnailUrl();
    }

    @BindingAdapter({"thumbnailUrl"})
    public static void setLoadImage(ImageView view, String thumbnailUrl) {
        Picasso.Builder builder = new Picasso.Builder(view.getContext());
        builder.downloader(new OkHttp3Downloader(view.getContext()));
        builder.build().load(thumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(view);
    }
}

