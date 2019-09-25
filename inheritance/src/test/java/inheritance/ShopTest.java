package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    Shop newShop;
    Review newReview;

    @Before
    public void setUp() throws Exception {
        newShop = new Shop("Apple", "a company that sells electronic hardware, software, and online services",4);
        newReview = new Review("This store is pretty expensive and their products have been stagnant for a couple of years now",
                            "Qyoung", 3.5, newShop);
    }

    // Test if toString is returning the correct string based on construction of the shop instance
    @Test
    public void testToString() {
        assertEquals("Apple is a company that sells electronic hardware, software, and online services with a price of $$$$", newShop.toString());
    }

    // Test if a shop instance can have reviews be added to it
    @Test
    public void testAddReviewMultipleReviews() {
        newShop.addReview(newReview);
        Review newReview2 = new Review("Expensive but their software is superb", "Steve Jobs", 4, newShop);
        newShop.addReview(newReview2);
        Review newReview3 = new Review("No innovation lately and they sells less powerful hardware for higher prices than their competitors",
                            "Window user", 1, newShop);
        newShop.addReview(newReview3);

        assertTrue(newShop.listOfReviews.contains(newReview));
        assertTrue(newShop.listOfReviews.contains(newReview2));
        assertTrue(newShop.listOfReviews.contains(newReview3));
    }


}