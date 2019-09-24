package inheritance;

public class McDonaldBallard extends McDonald {

    public String location;
    public McDonaldBallard(String name, String price, String location) {
        super(name, price);
        this.location = location;
    }
}
