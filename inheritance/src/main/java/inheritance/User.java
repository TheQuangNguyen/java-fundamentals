package inheritance;

import java.util.HashSet;

public class User {
    public String username;
    // hashset is used to store already reviewed restaurant
    public HashSet<Restaurant> reviewedRestaurant = new HashSet<>();

    public User(String username) {
        this.username = username;
    }

    // create a review for a certain restaurant then store the restaurant name inside the hashset
    public void createReview(Restaurant restaurant, Review review) {
        if (!reviewedRestaurant.contains(restaurant)) {
            restaurant.addReview(review);
            reviewedRestaurant.add(restaurant);
        } else {
            System.out.println(String.format("Review for %s was already made", restaurant.name));
        }
    }
}
