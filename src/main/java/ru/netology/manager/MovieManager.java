package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] watchLater = new Movie[length];

        System.arraycopy(movies, 0, watchLater, 0, movies.length);
        int lastIndex = movies.length - 1;
        watchLater[lastIndex] = movie;

        movies = watchLater;
    }

    public Movie[] getAll() {
        int countOfMovies = 10;
        Movie[] result = new Movie[countOfMovies];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
