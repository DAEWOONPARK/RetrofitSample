package com.example.retrofitsample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitsample.R;
import com.example.retrofitsample.databinding.CustomRowBinding;
import com.example.retrofitsample.viewmodel.MyViewModel;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MyViewModel viewModel;

    public MyAdapter(MyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CustomRowBinding binding = CustomRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).bind(viewModel, position);
        }
    }

    @Override
    public int getItemCount() {
        return viewModel.getDateList() == null ? 0 : viewModel.getDateList().size();
    }
}
