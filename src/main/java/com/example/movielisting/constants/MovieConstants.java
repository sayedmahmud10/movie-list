package com.example.movielisting.constants;

import com.example.movielisting.model.Movie;
import java.util.Arrays;
import java.util.List;

public class MovieConstants {

    public static final List<Movie> DEFAULT_MOVIES = Arrays.asList(
            new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", "2010", 160000000),
            new Movie("The Dark Knight", "Christian Bale", "Action", "2008", 185000000),
            new Movie("Interstellar", "Matthew McConaughey", "Sci-Fi", "2014", 165000000),
            new Movie("Titanic", "Leonardo DiCaprio", "Romance", "1997", 200000000)
    );

}
