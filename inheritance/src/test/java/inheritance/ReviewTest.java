package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    Review newReview;
    Restaurant newRestaurant;

    @Before
    public void setUp() throws Exception {
        newReview = new Review("This restaurant has good food and service", "Anonymous", 4.0, "Zapverr");
    }

    @Test
    public void testToString() {
        assertEquals("Anonymous has left a review about Zapverr commenting that \"This restaurant has good food and service\"" +
            " with a rating of 4.0 stars out of 5", newReview.toString());
    }

    // Test to see if adding low stars rating to numerous reviews would make the restaurant's rating go down.
    @Test
    public void testStarsRating() {
        newRestaurant.addReview(newReview);
        newReview = new Review("food was terrible and servers were rude", "Quang", 1.0, "Zapverr");
        newRestaurant.addReview(newReview);
        newReview = new Review("food was ok, not great, and servers did not check on me as often", "Chan", 3.0, "Zapverr");
        newRestaurant.addReview((newReview));

        assertEquals("The stars rating for Zapverr should be 3.0 right now", 3.0, newRestaurant.starsRating, 0.1);
    }
}