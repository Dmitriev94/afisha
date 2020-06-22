package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;

    Movie one = new Movie(1, "test1", "test1", "test1");
    Movie two = new Movie(2, "test2", "test2", "test2");
    Movie three = new Movie(3, "test3", "test3", "test3");
    Movie four = new Movie(4, "test4", "test4", "tes4");
    Movie five = new Movie(5, "test5", "test5", "test5");
    Movie six = new Movie(6, "test6", "test6", "test6");
    Movie seven = new Movie(7, "test7", "test7", "test7");
    Movie eight = new Movie(8, "test8", "test8", "test8");
    Movie nine = new Movie(9, "test9", "test9", "test9");
    Movie ten = new Movie(10, "test10", "test10", "test10");
    Movie eleven = new Movie(11, "test11", "test11", "test11");

    @Test
    void addTen() {
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, ten};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMoreThanTen() {
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, ten, eleven};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }

    @Test
    void shouldRemoveAll() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        manager.removeAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
        verify(repository).removeAll();
        verify(repository).findAll();
    }

    @Test
    void shouldFindById() {
        int idToFind = 4;
        Movie[] returned = new Movie[]{four};
        doReturn(returned).when(repository).findById(idToFind);
        Movie[] actual = manager.findById(idToFind);
        Movie[] expected = new Movie[]{four};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{one, two, three, five};
        doReturn(returned).when(repository).findAll();
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, three, two, one};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = new Movie[]{one, two, three, four, five, six, seven, eight, nine, ten};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMovie() {
        Movie[] returned = new Movie[]{one};
        doReturn(returned).when(repository).findAll();
        manager.add(one);
        Movie[] expected = new Movie[]{one};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();


    }



    @Test
    void shouldNotAddMovies() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldGetNumberMovies() {
        manager.setCustomAfishaLength(5);
        Movie[] returned = new Movie[]{one, two, three, four, five, six};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{six, five, four, three, two};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void IdNotFound() {
        int idToFind = 2;
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findById(idToFind);
        Movie[] actual = manager.findById(idToFind);
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void IdToRemoveNotFound() {
        int idToRemove = 6;
        Movie[] returned = new Movie[]{one, two, three, four, six};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{six, four, three, two, one};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }


    @Test
    void shouldSetCustomAfishaLength() {
        manager.setCustomAfishaLength(2);
        Movie[] returned = new Movie[]{one, two, three, four, five};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, four};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


}