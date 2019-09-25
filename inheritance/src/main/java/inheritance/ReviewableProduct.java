package inheritance;

// interface to specify that if a place has products that can be reviewed, it should implement this interface
public interface ReviewableProduct {
    // checks if that product actually exist within the place in order to review it
    boolean hasProduct (Object product);
    // add a product review to the place
    void addProductReview (Review productReview);
}
