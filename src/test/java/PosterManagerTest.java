import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Movie;
import ru.netology.PosterManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class PosterManagerTest {
    private PosterManager manager = new PosterManager();
    private Movie first = new Movie(1, "first", "Action");
    private Movie second = new Movie(2, "second", "Comedy");
    private Movie third = new Movie(3, "third", "Cartoon");
    private Movie fourth = new Movie(4, "fourth", "Horror");
    private Movie fifth = new Movie(5, "fifth", "Drama");
    private Movie sixth = new Movie(6, "sixth", "Adventure");
    private Movie seventh = new Movie(7, "seventh", "Detective");
    private Movie eighth = new Movie(8, "eighth", "Thriller");
    private Movie ninth = new Movie(9, "ninth", "Musical");
    private Movie tenth = new Movie(10, "tenth", "Western");
    private Movie eleventh = new Movie(11, "eleventh", "Documentary");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    void getLastWithQuantityMoreThanInList() {
        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastWithQuantityLessThanInList() {
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.findLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAll() {
        PosterManager manager = new PosterManager();
        manager.add(first);

        Movie[] expected = new Movie[]{first};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastAmount() {
        PosterManager manager = new PosterManager(1);
        manager.add(first);
        manager.add(second);

        Movie[] expected = new Movie[]{second};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);

    }
}
