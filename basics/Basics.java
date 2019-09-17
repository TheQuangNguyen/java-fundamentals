
// File name matches EXACTLY with class name
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Basics {

  // running a file means running the main method
  // the main method ALWAYS looks EXACTLY like this
  public static void main(String[] args) {
    System.out.println("Hello, Java!");

    Calendar cal = Calendar.getInstance();
    String currentMonth = new SimpleDateFormat("MMMM").format(cal.getTime());

    System.out.println(isItSalmonSeason(currentMonth));

    String myName = "Quang";

    // option 1 for creating an array
    // String[] names = new String[3];
    // names[0] = "Michelle";
    // names[1] = "Nicholas";
    // names[2] = "Jeff";

    // option 2
    String[] names = new String[] { "Michelle", "Nicholas", "Jeff" };
  }

  // writing method

  public static boolean isItSalmonSeason(String month) {
    if (month.equals("July") || month.equals("August") || month.equals("September")) {
      return true;
    } else {
      return false;
    }
  }
}