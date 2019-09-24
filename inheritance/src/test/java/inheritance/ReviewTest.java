package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    Review newReview;
    Restaurant newRestaurant;
    Review newReview2;
    Review newReview3;

    @Before
    public void setUp() throws Exception {
        newRestaurant = new Restaurant("Zapverr", "$$");
        newReview = new Review("This restaurant has good food and service",
                "Anonymous", 4.0, newRestaurant.name);
        newRestaurant.addReview(newReview);
        newReview2 = new Review("food was terrible and servers were rude", "Quang", 1.0, newRestaurant.name);
        newRestaurant.addReview(newReview2);
        newReview3 = new Review("food was ok, not great, and servers did not check on me as often", "Chan", 3.0, newRestaurant.name);
        newRestaurant.addReview((newReview3));
    }

    // Test if toString for Review would correctly return the string with all the instance varibles information in it
    @Test
    public void testToString() {
        assertEquals("Chan has left a review about Zapverr commenting that \"food was ok, not great, and servers did not check on me as often\"" +
            " with a rating of 3.0 stars out of 5", newReview3.toString());
    }

    // Test if we can update the stars for one review and change the stars rating of the restaurant
    @Test
    public void testUpdateStarsOneReview() {
        // change the last review in the setup method from 3.0 stars to 5.0 stars
        double currentStars = newRestaurant.getStarsRating();
        newReview3.updateStars(5.0);
        double updatedStars = newRestaurant.getStarsRating();

        // Testing if the stars rating of review changed
        assertEquals(5.0, newReview3.starsRating, 0.1);
        // Testing if the stars rating of the restaurant changed
        assertNotEquals(currentStars,updatedStars);
        // Testing if the stars rating of the restaurant is calculated correctly with the change
        assertEquals(3.8, updatedStars, 0.1);
    }

    // Test if we can update the stars for multiple reviews and change the stars rating of the restaurant
    @Test
    public void testUpdateStarsMultipleReviews() {
        // change a bunch of reviews stars rating
        double currentStars = newRestaurant.getStarsRating();
        newReview.updateStars(2.0);
        newReview2.updateStars(3.0);
        newReview3.updateStars(1.0);
        double updatedStars = newRestaurant.getStarsRating();

        // Testing if the stars rating of review changed
        assertEquals(2.0, newReview.starsRating, 0.1);
        assertEquals(3.0, newReview2.starsRating, 0.1);
        assertEquals(1.0, newReview3.starsRating, 0.1);
        // Testing if the stars rating of the restaurant changed
        assertNotEquals(currentStars,updatedStars);
        // Testing if the stars rating of the restaurant is calculated correctly with the change
        assertEquals(2.8, updatedStars, 0.1);
    }

}