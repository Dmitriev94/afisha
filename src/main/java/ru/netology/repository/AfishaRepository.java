package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {

    private Movie[] movies = new Movie[0];


    public Movie[] findAll() {

        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] watchLater = new Movie[length];

        System.arraycopy(movies, 0, watchLater, 0, movies.length);
        int lastIndex = watchLater.length - 1;
        watchLater[lastIndex] = movie;

        movies = watchLater;
    }

    public Movie[] findById(int id) {
        Movie[] findMovieById = new Movie[0];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() == id) {
                Movie[] tmp = new Movie[findMovieById.length+1];
                System.arraycopy(findMovieById, 0, tmp, 0, findMovieById.length);
                tmp[index] = item;
                index++;
                findMovieById = tmp;
            }
        }
        return findMovieById;
    }


    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] watchLater = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                watchLater[index] = item;
                index++;
            }
        }

        movies = watchLater;
    }


    public void removeAll() {
        movies = new Movie[0];

    }


}