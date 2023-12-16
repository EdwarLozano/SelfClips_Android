package com.example.moviefinderapp.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefinderapp.Network.MovieDto;
import com.example.moviefinderapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<MovieDto> posts;

    public MoviesAdapter(List<MovieDto> movies) {
        this.posts = posts;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieDto movie = posts.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        String yearWithHeart = movie.getYear() + " \u2764️";
        holder.year.setText(yearWithHeart);
        Picasso.get().load(movie.getPoster()).into(holder.poster);
        // Use Glide or another library if preferred
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    public static class MovieViewHolder extends RecyclerView.ViewHolder implements com.example.moviefinderapp.ui.Adapter.MovieViewHolder {
        public TextView title;
        public TextView year;
        public ImageView poster;

        public MovieViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            poster = itemView.findViewById(R.id.movie_poster);
        }

    }
}
