package ru.netoloygy.movies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void test() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastMoviesOverLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastMoviesBelowLimit() {
        MovieManager manager = new MovieManager(6);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastMoviesEqualLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 0");
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1", "Film 0"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastMoviesEmpty() {
        MovieManager manager = new MovieManager();

        String[] expected = {"NoFilms"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }
}
