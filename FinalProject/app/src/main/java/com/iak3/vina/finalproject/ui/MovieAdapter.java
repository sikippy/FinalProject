package com.iak3.vina.finalproject.ui;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iak3.vina.finalproject.R;
import com.iak3.vina.finalproject.model.MovieDetail;
import com.iak3.vina.finalproject.model.MovieEntity;
import com.iak3.vina.finalproject.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vwinata on 29/08/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter {

    public static interface ItemClickListener {
         void onItemClick(int position);
    }

    private static ItemClickListener itemClickListener;

    public MovieAdapter(@NonNull ItemClickListener itemClickListener,
                        @NonNull List<MovieEntity> items) {
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    private List<MovieEntity> items = new ArrayList<>();
    private List<MovieDetail> detailList = new ArrayList<>();

    public void setItems(List<MovieEntity> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(parent);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieHolder movieHolder = (MovieHolder) holder;
        movieHolder.bind(ImageUtils
                .generateImageUrl(items.get(position).getPosterPath()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public List<MovieEntity> getData() {
        return items;
    }

    public static class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(@LayoutRes int resId, ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        }
    }



    public static class MovieHolder extends BaseHolder  {

        private ImageView moviePosterView;

        public MovieHolder(ViewGroup parent) {
            super(R.layout.main_movie, parent);
            moviePosterView = (ImageView)
                    itemView.findViewById(R.id.movie_poster);
            moviePosterView.setClickable(true);
            moviePosterView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getId();
                    final int position = getAdapterPosition();
                    itemClickListener.onItemClick(position);
                    }
               });
        }


        public void bind(String imageUrl) {
            Picasso.with(itemView.getContext())
                    .load(imageUrl)
                    .fit()
                    .centerCrop()
                    .into(moviePosterView);
        }


    }
}