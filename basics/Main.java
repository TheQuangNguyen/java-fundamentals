import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(2);
        clock();
    }

    public static String pluralize(String word, int number) {
        if (number == 0 || number > 1) {
            return word + "s";
        } else if (number == 1) {
            return word;
        } else {
            return "invalid";
        }
    }

    public static void flipNHeads(int n) {
        double randomNumber;
        int numberOfHeads = 0;
        int count = 0;

        while (numberOfHeads != n) {
            randomNumber = Math.random();
            if (randomNumber < 0.50) {
                System.out.println("tails");
                count++;
            } else {
                System.out.println("heads");
                count++;
                numberOfHeads++;
            }
        }

        System.out.println("It took " + count + " flips to flip " + numberOfHeads + " head in a row.");
    }

    public static void clock() {
        LocalDateTime now = LocalDateTime.now();
        ;
        String currentTime;
        int cpuSpeed = 0; // keep track of number of operations for each iteration of while loop
        String previousTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // checks if the currentTime is equals to previousTime since if it is not, that
        // means a second has passed by and if so, display the time
        while (true) {
            now = LocalDateTime.now();
            cpuSpeed++;
            currentTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            cpuSpeed++;
            cpuSpeed++; // for checking if statement for every iteration
            if (!currentTime.equals(previousTime)) {
                System.out.println(currentTime + " " + ((double) cpuSpeed / 1000000) + " MHz");
                cpuSpeed = 0;
            }
            cpuSpeed++;
            previousTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    }

}