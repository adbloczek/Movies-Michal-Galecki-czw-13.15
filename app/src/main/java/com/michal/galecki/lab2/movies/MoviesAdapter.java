package com.michal.galecki.lab2.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView leftImage, rightImage;

        public MyViewHolder(View view) {
            super(view);
            leftImage = (ImageView) view.findViewById(R.id.movieList_imageView_leftGenre);
            rightImage = (ImageView) view.findViewById(R.id.movieList_imageView_rightGenre);
            title = (TextView) view.findViewById(R.id.movieList_textView_title);
            genre = (TextView) view.findViewById(R.id.movieList_textView_genre);
            year = (TextView) view.findViewById(R.id.movieList_textView_year);
        }
    }

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.leftImage.setImageResource(movie.getThumbnailId());
        holder.rightImage.setImageResource(movie.getThumbnailId());
        if (position % 2 == 0) {
            holder.leftImage.setVisibility(View.GONE);
            holder.rightImage.setVisibility(View.VISIBLE);
        } else {
            holder.rightImage.setVisibility(View.GONE);
            holder.leftImage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void deleteMovie(int position) {
        moviesList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, moviesList.size());
    }

    public Movie getMovie(int position) {
        return moviesList.get(position);
    }

}
