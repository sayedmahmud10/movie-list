package com.example.movielisting.model;

public class Movie {
    private String title;
    private String category;
    private String cast;
    private String releaseDate;
    private double budget;

    public Movie(String title, String category, String cast, String releaseDate, double budget) {
        this.title = title;
        this.category = category;
        this.cast = cast;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cast='" + cast + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", budget=" + budget +
                '}';
    }
}
