package com.example.retrofitsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.retrofitsample.adapter.MyAdapter;
import com.example.retrofitsample.databinding.ActivityMainBinding;
import com.example.retrofitsample.model.RetroPhoto;
import com.example.retrofitsample.network.RetrofitClientInstance;
import com.example.retrofitsample.viewmodel.MyViewModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyViewModel viewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MyViewModel();

        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        // TODO: Retrofit repository pattern 적용
        GetDataService service = RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetroPhoto>> call,@NonNull Response<List<RetroPhoto>> response) {
                progressDialog.dismiss();
                viewModel.setDataList(response.body());
                viewModel.onCreate();
            }

            @Override
            public void onFailure(@NonNull Call<List<RetroPhoto>> call,@NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this
                        , "Something went wrong... Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
