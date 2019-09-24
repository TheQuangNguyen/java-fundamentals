package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    Restaurant newRestaurant;
    @Before
    public void setUp() throws Exception {
        newRestaurant = new Restaurant("Zapverr", "$$");
    }

    // Test toString method to see if it prints out the expected sentence
    @Test
    public void testToString() {
        assertEquals("Zapverr has a rating of 5 stars out of 5 with a price of $$", newRestaurant.toString());
    }


}