package com.michal.galecki.lab2.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieSecondDetailsFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_second_details, container, false);

        final Bundle bundle = getArguments();
        if (bundle != null) {
            MovieImagesFragment images = (MovieImagesFragment) getChildFragmentManager().findFragmentById(R.id.fragment);
            images.setScreens(bundle.getInt("position"));
            MovieActorsFragment actors = (MovieActorsFragment) getChildFragmentManager().findFragmentById(R.id.fragment2);
            actors.setActors(bundle.getInt("position"));
        }
        return view;
    }
}
