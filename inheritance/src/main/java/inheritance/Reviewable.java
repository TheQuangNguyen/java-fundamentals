package inheritance;

// This interface define that a reviewable restaurant should have a method that enable the restaurant to add reviews to
// to its list, in other words, associate a review to itself
public interface Reviewable {
    String getName();
    void addReview(Review review);
//    double getStarsRating();
}
