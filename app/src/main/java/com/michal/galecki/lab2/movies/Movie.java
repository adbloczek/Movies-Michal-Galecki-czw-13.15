package com.michal.galecki.lab2.movies;

import java.util.ArrayList;

public class Movie {
    private String title, genre, year, description;
    private int posterId, thumbnailId;
    private ArrayList<Integer> screens;
    private ArrayList<String> actors;
    public static int SCREENS_NUMBER = 6;
    public static int ACTORS_NUMBER = 3;
    private float rating;

    public Movie(String title, String genre, String year, String description, int posterId, int thumbnailId, ArrayList<Integer> screens, ArrayList<String> actors) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.posterId = posterId;
        this.thumbnailId = thumbnailId;
        this.screens = screens;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public int getPosterId() {
        return posterId;
    }

    public int getThumbnailId() {
        return thumbnailId;
    }

    public ArrayList<Integer> getScreens() {
        return screens;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
