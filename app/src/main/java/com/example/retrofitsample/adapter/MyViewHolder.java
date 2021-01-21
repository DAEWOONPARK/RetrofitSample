package com.example.retrofitsample.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitsample.databinding.CustomRowBinding;
import com.example.retrofitsample.viewmodel.MyViewModel;

/**
 * Created by dwp on 2021-01-21.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    CustomRowBinding binding;

    MyViewHolder(CustomRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }

    public void bind(MyViewModel viewModel, int position) {
        binding.setViewmodel(viewModel);
        binding.setPosition(position);
        binding.executePendingBindings();
    }
}
