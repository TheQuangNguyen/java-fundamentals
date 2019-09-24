package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    // Test if we can create a review for user and have it store in the restaurant
    @Test
    public void testCreateReview() {
        Restaurant newRestaurant = new Restaurant("Zapverr", "$$");
        User newUser = new User("Qyoung");
        Review newReview = new Review("This place was ok", newUser.username, 3.0, newRestaurant.name);

        newUser.createReview(newRestaurant, newReview);
        Review createdReview = newRestaurant.listOfReview.get(0);

        // testing if this review in the list is the review we just created and put in the list
        assertEquals(newUser.username, createdReview.author);
        assertEquals("This place was ok", createdReview.body);
        assertEquals(3.0, createdReview.starsRating, 01);
        assertEquals(newRestaurant.name, createdReview.restaurantName);

    }
}