package inheritance;

import java.util.HashMap;
import java.util.LinkedList;

public class Restaurant {
    public String name;
    public double starsRating;
    public String price;
    private LinkedList<Review> listOfReview = new LinkedList<>();

    public Restaurant(String name, String price) {
        this.name = name;
        this.starsRating = 5;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s has a rating of %.1f stars out of 5 with a price of %s", this.name, this.starsRating, this.price);
    }

    public void addReview(Review review) {
        if (listOfReview.contains(review)) {
            System.out.println(String.format("Review for %s was already submitted", this.name));
        } else {
            listOfReview.add(review);
            starsRating = (starsRating + review.starsRating) / 2.0;
        }
    }
}
