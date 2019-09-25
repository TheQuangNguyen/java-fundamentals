package inheritance;

import java.util.HashSet;
import java.util.LinkedList;

// commented out code is for getting rid of the instance variable starsRating since for refactoring
// we make a method that calculate the stars on the fly instead

public class Restaurant implements Reviewable {
    public String name;
//    public double starsRating;
    public String price;
    public LinkedList<Review> listOfReviews = new LinkedList<>();

    public Restaurant(String name, String price) {
        this.name = name;
//        this.starsRating = 5;
        this.price = price;
    }

    @Override
    public String toString() {
        double starsRating = getStarsRating();
        return String.format("%s has a rating of %.1f stars out of 5 with a price of %s",
                            this.name, starsRating, this.price);
    }

    // A reviewable place should able to provide the review its name
    @Override
    public String getName() {
        return this.name;
    }

    // add a review to the restaurant list of reviews
    @Override
    public void addReview(Review review) {
        if (listOfReviews.contains(review)) {
            System.out.println(String.format("Review for %s was already submitted", this.name));
        } else {
            listOfReviews.add(review);
//            starsRating = (starsRating + review.starsRating) / 2.0;
        }
    }

    // calculate the starsRating of the restaurant by going through the list and take the average of all reviews
    // Initially the restaurant with no reviews with get starsRating of 5
    public double getStarsRating() {
        if (listOfReviews.isEmpty()) {
            return 5.0;
        }
        int count = 1;
        double sum = 5;
        for(Review review : listOfReviews) {
            count++;
            sum += review.starsRating;
        }
        return sum/count;
    }
}