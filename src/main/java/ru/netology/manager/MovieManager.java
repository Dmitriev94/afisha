package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieManager {

    private Movie[] movies = new Movie[0];

    private int defaultAfishaLength = 10;
    private int customAfishaLength;


    public MovieManager(int customAfishaLength) {
        this.customAfishaLength = customAfishaLength;
    }


    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] watchLater = new Movie[length];
        System.arraycopy(movies, 0, watchLater, 0, movies.length);
        int lastIndex = watchLater.length - 1;
        watchLater[lastIndex] = movie;
        movies = watchLater;
    }

    public Movie[] getAll() {

        Movie[] result = new Movie[0];
        if (customAfishaLength == 0 && movies.length <= defaultAfishaLength) {
            result = new Movie[movies.length];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (customAfishaLength == 0 && movies.length >= defaultAfishaLength) {
            result = new Movie[defaultAfishaLength];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        if (customAfishaLength != 0) {
            result = new Movie[customAfishaLength];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        return result;
    }
}
