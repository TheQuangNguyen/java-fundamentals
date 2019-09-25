package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater newTheater;

    @Before
    public void setUp() throws Exception {
        newTheater = new Theater("Regal Cinema");
    }

    // Testing toString if there is no movie added yet
    @Test
    public void testToStringNoMovie() {
        assertEquals("Regal Cinema does not have any movie shown right now", newTheater.toString());
    }

    // Testing toString if there are some movies added and also if it can add movies
    @Test
    public void testToStringMultipleMovies() {
        newTheater.addMovie("Avengers: Endgame");
        newTheater.addMovie("Avengers: Infinity War");
        newTheater.addMovie("Avengers: Age of Ultron");
        newTheater.addMovie("The Avengers");

        assertEquals("Regal Cinema is currently showing the following movies:" +
                    "\nAvengers: Endgame" +
                    "\nAvengers: Infinity War" +
                    "\nAvengers: Age of Ultron" +
                    "\nThe Avengers", newTheater.toString());

    }

    @Test
    public void addReview() {

    }

    @Test
    public void removeMovie() {
    }
}