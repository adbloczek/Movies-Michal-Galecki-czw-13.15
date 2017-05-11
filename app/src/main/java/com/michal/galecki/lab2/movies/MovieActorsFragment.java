package com.michal.galecki.lab2.movies;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieActorsFragment extends android.support.v4.app.Fragment {
    public View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.movie_actors, container, false);
        return view;
    }

    public void setActors(int position) {
        ArrayList<String> actorsList = MainActivity.movieList.get(position).getActors();

        TextView firstActor = (TextView) view.findViewById(R.id.movieActors_textView_firstActor);
        TextView secondActor = (TextView) view.findViewById(R.id.movieActors_textView_secondActor);
        TextView thirdActor = (TextView) view.findViewById(R.id.movieActors_textView_thirdActor);

        firstActor.setText(actorsList.get(0));
        secondActor.setText(actorsList.get(1));
        thirdActor.setText(actorsList.get(2));
    }
}
