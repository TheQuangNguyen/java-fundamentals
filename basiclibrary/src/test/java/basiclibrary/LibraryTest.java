/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basiclibrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static basiclibrary.Library.*;

public class LibraryTest {

    ////// Testing for roll method ///////

    @Test
    public void testRoll() {
        int[] testArray = roll(5);

        assertEquals(testArray.length, 5);
        for (int number: testArray) {
            assertTrue(number <= 6 && number > 0);
        }
    }

    @Test
    public void testRollZero() {
        int[] testArray = roll(0);

        assertEquals(testArray.length, 0);
        for (int number: testArray) {
            assertTrue(number <= 6 && number > 0);
        }
    }

    @Test
    public void testRollOne() {
        int[] testArray = roll(1);

        assertEquals(testArray.length, 1);
        for (int number: testArray) {
            assertTrue(number <= 6 && number > 0);
        }
    }

    ////////// Testing for containsDuplicates method /////////////////

    @Test
    public void testContainsZeroDuplicate() {
        assertFalse(containsDuplicates(new int[]{1,2,3,4,5}));
    }

    @Test
    public void testContainsOneDuplicate() {
        assertTrue(containsDuplicates(new int[]{1,2,3,4,1}));
    }

    @Test
    public void testContainsAllDuplicates() {
        assertTrue(containsDuplicates(new int[]{1,1,1,1,1}));
    }

    @Test
    public void testContainsDuplicatesEmpty() {
        assertFalse(containsDuplicates(new int[]{}));
    }

    @Test
    public void testContainsDuplicatesNegative() {
        assertFalse(containsDuplicates(new int[]{-1,1,2,3,5}));
    }


    ////////// Testing for Calculating Averages Method /////////////////

    // I use this answer to use assertEquals with delta values to tell the method how much decimal places I want my double result to match.
    // https://stackoverflow.com/questions/33274030/why-is-assertequalsdouble-double-deprecated-in-junit/33274179#33274179

    @Test
    public void testCalculateAveragesWholeNumber() {
        assertEquals("The average should be 3.00", 3.00d, calculateAverages(new int[]{1,2,3,4,5}), 0.01);
    }

    @Test
    public void testCalculateAveragesDecimalNumber() {
        assertEquals("The average should be 13.6667", 13.67d, calculateAverages(new int[]{1,4,7,23,45,2}), 0.01);
    }

    @Test
    public void testCalculateAveragesOneElement() {
        assertEquals("The average should be 17.00", 17.00d, calculateAverages(new int[]{17}), 0.01);
    }

    @Test
    public void testCalculateAveragesEmpty() {
        assertEquals("The average should be 0", 0.00d, calculateAverages(new int[]{}), 0.01);
    }


    //////////////// Testing for Arrays of Arrays method /////////////////////////

    @Test
    public void testCalculateLowestAverage2dArray() {
        int[][] weeklyMonthTemperatures = {
            {66,64,58,65,71,57,60},
            {57,65,65,70,72,65,51},
            {55,54,60,53,59,57,61},
            {65,56,55,52,55,62,57}
        };
        assertEquals("The lowest average should be 57.00", 57.00d , calculateLowestAverage2dArray(weeklyMonthTemperatures), 0.01);
    }

    @Test
    public void testCalculateLowestAverage2dArrayOneArray() {
        int[][] testArray = {
            {2,6,9,4,6,1}
        };
        assertEquals("The lowest average should be 4.67", 4.67d, calculateLowestAverage2dArray(testArray), 0.01);
    }

    @Test
    public void testCalculateLowestAverage2dArrayMultipleEmptyArrays() {
        int[][] testArray = {
            {},
            {},
            {},
        };
        assertEquals("The lowest average should be 0.00", 0.00d, calculateLowestAverage2dArray(testArray), 0.01);
    }

    @Test
    public void testCalculateLowestAverage2dArrayMultipleOneElementArrays() {
        int[][] testArray = {
            {1},
            {2},
            {1},
        };
        assertEquals("The lowest average should be 1.00", 1.00d, calculateLowestAverage2dArray(testArray), 0.01);
    }


    /////////////////////////// Testing for Maps Method ////////////////////////////////////


    // Test for normal temperatures data
    @Test
    public void testTemperatureNotSeen() {
        int[][] weeklyMonthTemperatures = {
            {66, 64, 58, 65, 71, 57, 60},
            {57, 65, 65, 70, 72, 65, 51},
            {55, 54, 60, 53, 59, 57, 61},
            {65, 56, 55, 52, 55, 62, 57}
        };

        assertEquals("The temperature that was never seen should be 63,67,68,69",
            "High: 72\n" +
                "Low: 51\n" +
                "Never saw temperature: 63\n" +
                "Never saw temperature: 67\n" +
                "Never saw temperature: 68\n" +
                "Never saw temperature: 69\n",
            temperatureNotSeen(weeklyMonthTemperatures));
    }
//
//    // Testing if all data was the same
//    @Test
//    public void testTemperatureNotSeenDuplicates() {
//        int[][] weeklyMonthTemperatures = {
//            {60,60,60,60,60,60,60},
//            {60,60,60,60,60,60,60},
//            {60,60,60,60,60,60,60},
//            {60,60,60,60,60,60,60}
//        };
//
//        assertEquals("The temperature that was never seen should be N/A",
//            "Never saw temperatures: 63,67,68,69",
//            temperatureNotSeen(weeklyMonthTemperatures));
//    }

    // Testing if there was not any temperatures that were not seen


    //////////////////////////////// Testing for tallying election method ///////////////////////////////


    // Testing for a normal case
    @Test
    public void testTally() {
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        String winner = tally(votes);

        assertEquals("The winner should be Bush", "Bush", winner);
    }

    // Testing if there is only one vote
    @Test
    public void testTallyOneVote() {
        List<String> votes = new ArrayList<>();
        votes.add("Bush");

        String winner = tally(votes);

        assertEquals("The winner should be Bush", "Bush", winner);
    }

    // Testing if there is only no vote
    @Test
    public void testTallyZeroVote() {
        List<String> votes = new ArrayList<>();

        String winner = tally(votes);

        assertEquals("The winner should be nobody", "Nobody", winner);
    }

    // Testing if there is a tie in vote
    @Test
    public void testTallyEqualVotes() {
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");

        String winner = tally(votes);

        assertTrue("The winners should include Bush, Shrub, and Hedge", winner.contains("Bush"));
        assertTrue("The winners should include Bush, Shrub, and Hedge", winner.contains("Shrub"));
        assertTrue("The winners should include Bush, Shrub, and Hedge", winner.contains("Hedge"));
    }
}
