package inheritance;

public class Review {
    public String body;
    public String author;
    public double starsRating;
    public Reviewable place;
    public Object product;

    public Review(String body, String author, double starsRating, Reviewable place) {
        this.body = body;
        this.author = author;
        this.starsRating = starsRating;
        this.place = place;
    }

    public Review(String body, String author, double starsRating, Reviewable place, Object product) {
        this.body = body;
        this.author = author;
        this.starsRating = starsRating;
        this.place = place;
        if (place instanceof ReviewableProduct) {
            this.product = product;
        } else {
            throw new IllegalArgumentException("The place needs to have reviewable products");
        }
    }

    // make toString method that takes the instance variables and use them in a sentence to describe the review
    @Override
    public String toString() {
        return String.format("%s has left a review about %s commenting that \"%s\" with a rating of %.1f stars out of 5",
        this.author, this.place.getName(), this.body, this.starsRating);
    }

    // update the stars for this review
    public void updateStars(double stars) {
        this.starsRating = stars;
    }
}
