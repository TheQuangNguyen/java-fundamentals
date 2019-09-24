package inheritance;

public class Review {
    public String body;
    public String author;
    public double starsRating;
    public String restaurantName;

    public Review(String body, String author, double starsRating, String restaurantName) {
        this.body = body;
        this.author = author;
        this.starsRating = starsRating;
        this.restaurantName = restaurantName;
    }

    // make toString method that takes the instance variables and use them in a sentence to describe the review
    @Override
    public String toString() {
        return String.format("%s has left a review about %s commenting that \"%s\" with a rating of %.1f stars out of 5",
        this.author, this.restaurantName, this.body, this.starsRating);
    }

    // update the stars for this review
    public void updateStars(double stars) {
        this.starsRating = stars;
    }
}
