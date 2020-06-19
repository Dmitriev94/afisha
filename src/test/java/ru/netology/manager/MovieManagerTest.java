package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager movieManager = new MovieManager();



    @Test
    void add() {
        Movie one = new Movie(1,"test1", "test1", "test1") ;

        movieManager.add(one);
        movieManager.getAll();
        Movie[] expected = new Movie[]{one};
        Movie[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);
    }



    @Test
    void addTen() {
        Movie one = new Movie(1,"test1", "test1", "test1");
        Movie two = new Movie(2,"test2", "test2", "test2");
        Movie three = new Movie(3,"test3", "test3", "test3");
        Movie four = new Movie(4,"test4", "test4", "tes4");
        Movie five = new Movie(5,"test5", "test5", "test5");
        Movie six = new Movie(6,"test6", "test6", "test6");
        Movie seven = new Movie(7,"test7", "test7", "test7");
        Movie eight = new Movie(8,"test8", "test8", "test8");
        Movie nine = new Movie(9,"test9", "test9", "test9");
        Movie ten = new Movie(10,"test10", "test10", "test10");
        movieManager.add(one);
        movieManager.add(two);
        movieManager.add(three);
        movieManager.add(four);
        movieManager.add(five);
        movieManager.add(six);
        movieManager.add(seven);
        movieManager.add(eight);
        movieManager.add(nine);
        movieManager.add(ten);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }
    @Test
    void addMoreThanTen() {
        Movie one = new Movie(1,"test1", "test1", "test1");
        Movie two = new Movie(2,"test2", "test2", "test2");
        Movie three = new Movie(3,"test3", "test3", "test3");
        Movie four = new Movie(4,"test4", "test4", "tes4");
        Movie five = new Movie(5,"test5", "test5", "test5");
        Movie six = new Movie(6,"test6", "test6", "test6");
        Movie seven = new Movie(7,"test7", "test7", "test7");
        Movie eight = new Movie(8,"test8", "test8", "test8");
        Movie nine = new Movie(9,"test9", "test9", "test9");
        Movie ten = new Movie(10,"test10", "test10", "test10");
        Movie eleven = new Movie(11,"test11", "test11", "test11");
        movieManager.add(one);
        movieManager.add(two);
        movieManager.add(three);
        movieManager.add(four);
        movieManager.add(five);
        movieManager.add(six);
        movieManager.add(seven);
        movieManager.add(eight);
        movieManager.add(nine);
        movieManager.add(ten);
        movieManager.add(eleven);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldUseNoArgsConstructor() {
        movieManager.setCustomAfishaLength(5);
        Movie one = new Movie(1,"test1", "test1", "test1");
        Movie two = new Movie(2,"test2", "test2", "test2");
        Movie three = new Movie(3,"test3", "test3", "test3");
        Movie four = new Movie(4,"test4", "test4", "tes4");
        Movie five = new Movie(5,"test5", "test5", "test5");
        Movie six = new Movie(6,"test6", "test6", "test6");
        Movie seven = new Movie(7,"test7", "test7", "test7");
        Movie eight = new Movie(8,"test8", "test8", "test8");
        Movie nine = new Movie(9,"test9", "test9", "test9");
        Movie ten = new Movie(10,"test10", "test10", "test10");
        movieManager.add(one);
        movieManager.add(two);
        movieManager.add(three);
        movieManager.add(four);
        movieManager.add(five);
        movieManager.add(six);
        movieManager.add(seven);
        movieManager.add(eight);
        movieManager.add(nine);
        movieManager.add(ten);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six};
        assertArrayEquals(expected, actual);
    }


}