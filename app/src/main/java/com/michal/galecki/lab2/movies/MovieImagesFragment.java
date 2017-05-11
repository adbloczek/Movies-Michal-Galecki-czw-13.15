package com.michal.galecki.lab2.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MovieImagesFragment extends android.support.v4.app.Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.movie_images, container, false);
        return view;
    }

    public void setScreens(int position) {
        ArrayList<Integer> screensIndices = MainActivity.movieList.get(position).getScreens();

        ImageView screen1 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen1);
        ImageView screen2 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen2);
        ImageView screen3 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen3);
        ImageView screen4 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen4);
        ImageView screen5 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen5);
        ImageView screen6 = (ImageView) view.findViewById(R.id.movieImages_imageView_screen6);

        screen1.setImageResource(screensIndices.get(0));
        screen2.setImageResource(screensIndices.get(1));
        screen3.setImageResource(screensIndices.get(2));
        screen4.setImageResource(screensIndices.get(3));
        screen5.setImageResource(screensIndices.get(4));
        screen6.setImageResource(screensIndices.get(5));
    }
}
