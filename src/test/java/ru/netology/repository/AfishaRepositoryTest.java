package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Movie one = new Movie(1, "test1", "test1", "test1");
    Movie two = new Movie(2, "test2", "test2", "test2");
    Movie three = new Movie(3, "test3", "test3", "test3");
    Movie four = new Movie(4, "test4", "test4", "tes4");
    Movie five = new Movie(5, "test5", "test5", "test5");
    Movie six = new Movie(6, "test6", "test6", "test6");

    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
        repository.save(six);
    }

    @Test
    void shouldSave() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one, two, three, four, five, six};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one, two, three, four, five, six};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{one, two, four, five, six};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 5;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[]{five};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        int idToFind = 7;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }


}
