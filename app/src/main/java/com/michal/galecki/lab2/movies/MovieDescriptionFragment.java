package com.michal.galecki.lab2.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDescriptionFragment extends android.support.v4.app.Fragment {
    View view;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.movie_description, container, false);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            TextView title = (TextView) view.findViewById(R.id.movieDescription_textView_title);
            TextView description = (TextView) view.findViewById(R.id.movieDescription_textView_description);
            ImageView poster = (ImageView) view.findViewById(R.id.movieDescription_imageView_title);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.movieDescription_ratingBar);
            position = bundle.getInt("position");
            title.setText(MainActivity.movieList.get(position).getTitle() + " (" + MainActivity.movieList.get(position).getYear() + ")");
            description.setText(MainActivity.movieList.get(position).getDescription());
            poster.setImageResource(MainActivity.movieList.get(position).getPosterId());
            ratingBar.setRating(MainActivity.movieList.get(position).getRating());
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.movieDescription_ratingBar);
        MainActivity.movieList.get(position).setRating(ratingBar.getRating());
    }
}
