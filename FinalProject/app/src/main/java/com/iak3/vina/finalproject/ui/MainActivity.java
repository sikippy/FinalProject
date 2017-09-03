package com.iak3.vina.finalproject.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.iak3.vina.finalproject.R;
import com.iak3.vina.finalproject.model.MovieEntity;
import com.iak3.vina.finalproject.model.MovieResponse;
import com.iak3.vina.finalproject.network.NetworkManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NetworkManager.NetworkCallback,MovieAdapter.ItemClickListener {

    public static final String TAG = "MainActivity";
    private static final int REQUEST_CODE_UPDATE_RECYCLER_VIEW = 42;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private boolean isFavoriteCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        NetworkManager.getPopularMovie(1, this);



    }

    private void setupRecyclerView() {
        List<MovieEntity> items = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MovieAdapter(MainActivity.this,items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        // Menampilkan Toast yang menunjukkan posisi yang diklik
        // CustomToast.show(MainActivity.this, "Item with position " + position + " clicked");

        // Mendapatkan MovieAdapter
        MovieAdapter adapter = (MovieAdapter) recyclerView.getAdapter();

        // Mendapatkan data dari MovieAdapter
        List<MovieEntity> movieList = adapter.getData();

        // Membuat Intent untuk membuka DetailActivity
        Intent openDetailActivityIntent = new Intent(MainActivity.this, DetailActivity.class);

        // Mendapatkan data dengan posisi yang diklik
        MovieEntity movieData = movieList.get(position);

        openDetailActivityIntent.putExtra("id",movieData.id);
              // Set data ke Intent
        openDetailActivityIntent.putExtra(DetailActivity.MOVIE_KEY, movieData);

        // Start DetailActivity
        if (isFavoriteCategory) {
            startActivityForResult(openDetailActivityIntent, REQUEST_CODE_UPDATE_RECYCLER_VIEW);
        } else {
            startActivity(openDetailActivityIntent);
        }
    }



    @Override
    public void onFailure(Throwable throwable) {
        Log.e(TAG, "Fail", throwable);
    }

    @Override
    public void onSuccess(MovieResponse movieResponse) {
        adapter.setItems(movieResponse.getResults());
    }
}