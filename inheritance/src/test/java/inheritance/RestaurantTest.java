package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    Restaurant newRestaurant;
    Review newReview;
    @Before
    public void setUp() throws Exception {
        newRestaurant = new Restaurant("Zapverr", "$$");
        newReview = new Review("This restaurant has good food and service",
                            "Anonymous", 4.0, newRestaurant.name);
    }

    // Test toString method to see if it prints out the expected sentence
    @Test
    public void testRestaurantToString() {
        assertEquals("Zapverr has a rating of 5.0 stars out of 5 with a price of $$", newRestaurant.toString());
    }

    // Test if the restaurant can add reviews and store them correctly
    @Test
    public void testRestaurantStoringReviews() {
        newRestaurant.addReview(newReview);
        Review newReview2 = new Review("food was terrible and servers were rude", "Quang", 1.0, newRestaurant.name);
        newRestaurant.addReview(newReview2);
        Review newReview3 = new Review("food was ok, not great, and servers did not check on me as often", "Chan", 3.0, newRestaurant.name);
        newRestaurant.addReview((newReview3));

        assertTrue(newRestaurant.listOfReview.contains(newReview));
        assertTrue(newRestaurant.listOfReview.contains(newReview2));
        assertTrue(newRestaurant.listOfReview.contains(newReview3));
    }

    // Test if we can get the current stars rating of the restaurant
    // Test to see if adding low stars rating to numerous reviews would make the restaurant's rating go down.
    @Test
    public void testStarsRatingMultipleReviews() {
        newRestaurant.addReview(newReview);
        newReview = new Review("food was terrible and servers were rude", "Quang", 1.0, newRestaurant.name);
        newRestaurant.addReview(newReview);
        newReview = new Review("food was ok, not great, and servers did not check on me as often", "Chan", 3.0, newRestaurant.name);
        newRestaurant.addReview((newReview));

        assertEquals("The stars rating for Zapverr should be 3.3 right now", 3.3, newRestaurant.getStarsRating(), 0.1);
    }

    // Test if we can get current stars rating when there are no reviews yet
    @Test
    public void testStarsRatingNoReview() {
        assertEquals("This should display 5.0 because a new restaurant start with 5 stars",
                    5.0, newRestaurant.getStarsRating(), 0.1);
    }

    // Test if we can get current stars rating when there are only 1 review
    @Test
    public void testStarsRatingOneReview() {
        newRestaurant.addReview(newReview);
        assertEquals(4.5, newRestaurant.getStarsRating(), 0.1);
    }

}