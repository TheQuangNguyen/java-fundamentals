package inheritance;

import org.checkerframework.checker.units.qual.C;

import java.util.LinkedList;

public class Shop implements Reviewable {
    public String name;
    public String description;
    public int price;
    public LinkedList<Review> listOfReviews;

    public Shop(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.listOfReviews = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("%s is %s with a price of ", this.name, this.description));
        for (int i = 0; i < price; i++) {
            result.append("$");
        }
        return result.toString();
    }

    // A reviewable place should able to provide the review its name
    @Override
    public String getName() {
        return this.name;
    }

    // Add a review to the list of reviews for the shop
    @Override
    public void addReview(Review review) {
        if (listOfReviews.contains(review)) {
            throw new IllegalArgumentException(String.format("Review for %s was already submitted", this.name));
        } else {
            listOfReviews.add(review);
        }
    }
}
