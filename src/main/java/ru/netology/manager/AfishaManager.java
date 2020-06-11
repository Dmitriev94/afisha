package ru.netology.manager;

import ru.netology.domain.Movie;

import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private AfishaRepository.MovieRepository repository;

    public AfishaManager(AfishaRepository.MovieRepository repository) {
        this.repository = repository;
    }

    public void add (Movie movie){
        repository.save(movie);
    }
    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        int countOfMovies = 10;
        Movie[] result = new Movie[countOfMovies];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}


