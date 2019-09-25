package inheritance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Theater implements Reviewable,ReviewableProduct {

    public String name;
    public LinkedList<String> movies;
    public LinkedList<Review> listOfReviews;
    public LinkedList<Review> listOfMovieReviews;

    public Theater(String name) {
        this.name = name;
        this.movies = new LinkedList<>();
        this.listOfReviews = new LinkedList<>();
        this.listOfMovieReviews = new LinkedList<>();
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

    // add a movie review to the list. This is specified in RenewableProduct interface
    @Override
    public void addProductReview(Review productReview) {
        if (listOfMovieReviews.contains(productReview)) {
            System.out.println(String.format("Review for %s was already submitted", productReview.product.toString()));
        } else {
            listOfMovieReviews.add(productReview);
        }
    }

    // checks to see if this theater has the movie that a review is going to be for. This is specified in RenewableProduct interface
    @Override
    public boolean hasProduct(Object product) {
        return movies.contains(product);
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
        // declare an iterator to go through the list and remove any reviews about the movie we are removing
        // an iterator is needed to avoid ConcurrentModificationException when going through a list
        // and remove elements at the same time
        Iterator<Review> i = listOfMovieReviews.iterator();

        while (i.hasNext()) {
            Review currentReview = i.next();
            if (currentReview.product.equals(movie)) {
                i.remove();
            }
        }
    }


}
