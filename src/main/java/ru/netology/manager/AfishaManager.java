package ru.netology.manager;

import ru.netology.domain.Movie;

import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    private AfishaRepository repository;


    public AfishaManager(AfishaRepository repository) {

        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        if (customAfishaLength == 0 && movies.length <= defaultAfishaLength) {
            result = new Movie[movies.length];
        }
        if (customAfishaLength == 0 && movies.length >= defaultAfishaLength++) {
            result = new Movie[10];
        }
        if (customAfishaLength != 0 && movies.length >= customAfishaLength) {
            result = new Movie[customAfishaLength];
        }
        if (customAfishaLength != 0 && movies.length < customAfishaLength) {
            result = new Movie[movies.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
    public void removeAll() {
        repository.removeAll();
    }

    public Movie[] findById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}


