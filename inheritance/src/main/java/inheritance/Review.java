package inheritance;

public class Review {
    public String body;
    public String author;
    public double starsRating;
    public String reviewedRestaurant;

    public Review(String body, String author, double starsRating, String reviewedRestaurant) {
        this.body = body;
        this.author = author;
        this.starsRating = starsRating;
        this.reviewedRestaurant = reviewedRestaurant;
    }

    @Override
    public String toString() {
        return String.format("%s has left a review about %s commenting that \"%s\" with a rating of %.1f stars out of 5",
        this.author, this.reviewedRestaurant, this.body, this.starsRating);
    }
}
