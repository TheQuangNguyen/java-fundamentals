package inheritance;

import java.util.HashSet;
import java.util.LinkedList;

public class Theater implements Reviewable {

    public String name;
    public LinkedList<String> movies;
    public LinkedList<Review> listOfReviews;

    public Theater(String name) {
        this.name = name;
        this.movies = new LinkedList<>();
        this.listOfReviews = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        // Account for message if there is no movie in the list for the theater
        if (movies.isEmpty()) {
            return String.format("%s does not have any movie shown right now", this.name);
        }
        StringBuilder result = new StringBuilder(String.format("%s is currently showing the following movies:", this.name));
        for (String movie: movies) {
            result.append(String.format("\n%s", movie));
        }
        return result.toString();
    }

    // add a review to the list of reviews for the theater
    @Override
    public void addReview(Review review) {
        if (listOfReviews.contains(review)) {
            System.out.println(String.format("Review for %s was already submitted", this.name));
        } else {
            listOfReviews.add(review);
        }
    }

    // add movies to list, if movies already shown in theater then it wont be added to list
    public void addMovie(String movie) {
        if (!movies.contains(movie)) {
            movies.add(movie);
        }
    }

    // remove movie from list
    public void removeMovie(String movie) {
        movies.remove(movie);
    }


}
