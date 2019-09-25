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

    // Testing if we can add reviews to an instance of theater for the theater and not the movie.
    @Test
    public void testAddReviewTheater() {
        // create reviews
        Review newReview = new Review("Theater was clean and food was not that overpriced", "Qyoung",
                                    4, newTheater);
        Review newReview2 = new Review("Theater was raggedy and food was pretty overpriced", "Qyoung",
                2, newTheater);
        Review newReview3 = new Review("Theater was clean but not a good selection of current movies", "Qyoung",
                3, newTheater);

        // add reviews for the theater
        newTheater.addReview(newReview);
        newTheater.addReview(newReview2);
        newTheater.addReview(newReview3);

        // see if the list of reviews have the reviews that were just created
        assertTrue(newTheater.listOfReviews.contains(newReview));
        assertTrue(newTheater.listOfReviews.contains(newReview2));
        assertTrue(newTheater.listOfReviews.contains(newReview3));
    }

    // Testing if we can add reviews for a specific movie from the theater
    @Test
    public void testAddMovieReview() {
        // add movies to the theater
        newTheater.addMovie("Avengers: Endgame");
        newTheater.addMovie("Avengers: Infinity War");
        newTheater.addMovie("Avengers: Age of Ultron");
        newTheater.addMovie("The Avengers");

        // add reviews for one movie from this theater
        Review newReview = new Review("Ending was so sad", "Qyoung",
                                    4, newTheater, "Avengers: Endgame");
        Review newReview2 = new Review("Best way to end a decade of adventures in the MCU", "MCU superfan",
                                    5, newTheater,"Avengers: Endgame");
        Review newReview3 = new Review("DC is better", "No one", 1, newTheater,
                                        "Avengers: Endgame");

        // testing if each reviews have its product be one of the movie
        assertEquals("Avengers: Endgame", newReview.product);
        assertEquals("Avengers: Endgame", newReview2.product);
        assertEquals("Avengers: Endgame", newReview3.product);

        // add the movie reviews to the list
        newTheater.addProductReview(newReview);
        newTheater.addProductReview(newReview2);
        newTheater.addProductReview(newReview3);

        // check if the list has the movie reviews
        assertTrue(newTheater.listOfMovieReviews.contains(newReview));
        assertTrue(newTheater.listOfMovieReviews.contains(newReview2));
        assertTrue(newTheater.listOfMovieReviews.contains(newReview3));

    }

    // test to see if we can remove a movie from the list of movies that the theater offers.
    // Also see if we can remove the reviews that are associated with that movie
    @Test
    public void removeMovie() {
        // add movies to the theater
        newTheater.addMovie("Avengers: Endgame");
        newTheater.addMovie("Avengers: Infinity War");
        newTheater.addMovie("Avengers: Age of Ultron");
        newTheater.addMovie("The Avengers");

        // add reviews for two movies from this theater
        Review newReview = new Review("Ending was so sad", "Qyoung",
                4, newTheater, "Avengers: Endgame");
        Review newReview2 = new Review("Best way to end a decade of adventures in the MCU", "MCU superfan",
                5, newTheater,"Avengers: Endgame");
        Review newReview3 = new Review("DC is better", "No one", 1, newTheater,
                "Avengers: Infinity War");

        // add the movie reviews to the list
        newTheater.addProductReview(newReview);
        newTheater.addProductReview(newReview2);
        newTheater.addProductReview(newReview3);

        // verify that the movie we about to remove is in the list
        assertTrue(newTheater.movies.contains("Avengers: Endgame"));
        assertTrue(newTheater.movies.contains("Avengers: Infinity War"));

        // verify that the list has the movie reviews
        assertTrue(newTheater.listOfMovieReviews.contains(newReview));
        assertTrue(newTheater.listOfMovieReviews.contains(newReview2));
        assertTrue(newTheater.listOfMovieReviews.contains(newReview3));

        // remove the movie
        newTheater.removeMovie("Avengers: Endgame");

        // verify that the movie is remove from the list
        assertFalse(newTheater.movies.contains("Avengers: Endgame"));

        // verify that the only review left is the third one that was for Infinity War and not Endgame
        assertTrue(newTheater.listOfMovieReviews.contains(newReview3));
        assertFalse(newTheater.listOfMovieReviews.contains(newReview));
        assertFalse(newTheater.listOfMovieReviews.contains(newReview2));
    }
}