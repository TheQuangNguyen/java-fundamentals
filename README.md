# Java Fundamentals 

This repo contains labs that covers Java fundamentals.

## Lab 1 - Basics

### Feature Tasks

[Code Solution to Lab 1](https://github.com/TheQuangNguyen/java-fundamentals/blob/master/basics/Main.java)

#### 1. Pluralize

Write a function called pluralize that accepts a word and a number and returns a string with the word pluralized with an “s” if the number is zero, or greater than one.

#### 2. Flipping Coins

Write a function called flipNHeads that accepts an integer n and flips coins until n heads are flipped in a row. Simulate coin flipping by choosing a random number between 0 and 1. Numbers below .5 are considered tails. Numbers at and above .5 are considered heads. Print out heads or tails on one line for each flip. Print It took FLIPS flips to flip N heads in a row. once n heads have been in a row.

#### 3. Command Line Clock

Write a method clock that uses Java’s built-in LocalDateTime object to constantly print out the current time to the console, second by second. The program should run until someone manually kills it with CTRL-C or presses the “stop” button in their IDE. Each time should only be printed once. Your program should detect when the seconds increase and only print something out when the timestamp changes.

## Lab 2 - Arrays, Loops, Imports, ArrayLists

### Feature Tasks

[Code Solution to Lab 2](https://github.com/TheQuangNguyen/java-fundamentals/blob/master/basiclibrary/src/main/java/basiclibrary/Library.java)

#### 1. Rolling Dice

Write a method called roll that accepts an integer n and rolls a six-sided dice n times. The method should return an array containing the values of the rolls.

#### 2. Contains Duplicates

Write a method called containsDuplicates that returns true or false depending on whether the array contains duplicate values.

#### 3. Calculating Averages

Write a method that accepts an array of integers and calculates and returns the average of all the values in the array.

#### 4. Arrays of Arrays

Given an array of arrays calculate the average value for each array and return the array with the lowest average.

## Lab 3 - Maps, File I/O, and Testing

### Feature Tasks

[Code Solution to First Two Problems](https://github.com/TheQuangNguyen/java-fundamentals/blob/master/basiclibrary/src/main/java/basiclibrary/Library.java)

#### 1. Analyzing Weather Data

```
// Daily average temperatures for Seattle, October 1-28 2017
int[][] weeklyMonthTemperatures = {
  {66, 64, 58, 65, 71, 57, 60},
  {57, 65, 65, 70, 72, 65, 51},
  {55, 54, 60, 53, 59, 57, 61},
  {65, 56, 55, 52, 55, 62, 57}
};
```

Use the October Seattle weather data above. Iterate through all of the data to find the min and max values. Use a HashSet of type Integer to keep track of all the unique temperatures seen. Finally, iterate from the min temp to the max temp and create a String containing any temperature not seen during the month. Return that String.

Expected Output
```
High: 72
Low: 51
Never saw temperature: 63
Never saw temperature: 67
Never saw temperature: 68
Never saw temperature: 69
```

#### 2. Tallying Election 

Write a function called tally that accepts a List of Strings representing votes and returns one string to show what got the most votes.

```
// within your main method...
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
System.out.println(winner + " received the most votes!");
```

#### 3. Javascript Linter

[Code For JS linter](https://github.com/TheQuangNguyen/java-fundamentals/blob/master/linter/src/main/java/linter/App.java)

Write a method that reads a JavaScript file with a given Path, and generates an error message whenever it finds a line that doesn’t end in a semi-colon.

Read through the file line by line. Create a string that contains a message such as "Line 3: Missing semicolon." if a line is missing a semicolon.

Don’t show an error if the line is empty.
Don’t show an error if the line ends with an opening curly brace {
Don’t show an error if the line ends with an closing curly brace }
Don’t show an error if the line contains if or else

## Lab 6 - Composition and Inheritance, Part 1

### Feature Tasks

[Code Implementation of Feature Tasks](https://github.com/TheQuangNguyen/java-fundamentals/tree/master/inheritance/src/main/java/inheritance)

1. Create a class to represent a Restaurant. Each Restaurant should have a name, a number of stars betweeen 0 and 5, and a price category (i.e. number of dollar signs).
    - Implement a Restaurant constructor.
    - Test that your Restaurant constructor is behaving reasonably.
    - Implement a reasonable toString method for Restaurants.
    - Write a test to create an instance of Restaurant and ensure that its toString is working properly.

2. Create a class to represent a Review. Each Review should have a body, an author, and a number of stars.
    - Write a Review constructor.
    - Test that your constructor is working reasonably.
    - Implement a reasonable toString method for Reviews.
    - Write a test to create an instance of Review and ensure that its toString is working properly.

3. A Review should be about a single Restaurant. Choose an implementation for this, and implement it.
    - Update your toString and constructor methods appropriately, and also update your testing code to test this new functionality.

4. Add an instance method addReview to your Restaurant class. This method should take in a Review instance, and associate that review with this Restaurant. The specific methodology for this will vary, depending on the implementation you chose above.
    - Add tests to ensure that when you call addReview, the association is created between the Restaurant and the Review.

5. When you associate a review with a restaurant, that restaurant’s star rating should change. Ensure that your addReview method updates the Restaurant star rating appropriately, and add tests. (In particular, ensure that if you’re trying to call addReview when the restaurant and the review are already associated, the star rating of the restaurant does not update.)

6. Add an updateStars method to the Review class. This method should update the stars for that review, and, if the review is associated with a restaurant, also update the number of stars for that restaurant.

7. Refactor: keeping track of stars for restaurants is getting complicated. Get rid of that instance variable, and instead make this an instance method that calculates a restaurant’s star rating on the fly when it’s called.

8. Create another class for a User, so that we know which reviews were written by the same User. Ensure that a single User can’t submit multiple Reviews for the same Restaurant.

## Lab 7 - Composition and Inheritance, Part 2

### Feature Tasks

[Code Implementation of Feature Tasks](https://github.com/TheQuangNguyen/java-fundamentals/tree/master/inheritance/src/main/java/inheritance)

1. The users want shops! Create a Shop class; a Shop should have a name, description, and number of dollar signs.
    - Implement a constructor for a Shop.
    - Implement a reasonable toString method for Shops.
    - Add tests for the basics of your Shop class.

2. The users also want to review shops!
    - It would be great if a Review could be about either a Shop or a Restaurant. Choose an implementation, and make this possible.
    - Ensure that your Shop class has an instance method to add a review about that shop, and that it works just as well as the Restaurant instance method with the same purpose.
    - Write tests for this functionality.

3. The users want theaters! Create a Theater class; a Theater should have a name and all of the movies currently showing there. (Strings are fine for the movies; no need to create another class.)
    - Implement a constructor for a Theater.
    - Write addMovie and removeMovie instance methods that allow the theater to update which movies are being shown.
    - Implement a reasonable toString method for Theaters.
    - Test your Theater functionality.

4. Review all the things!
    - Ensure that your Theater is just as reviewable as your Restaurant and your Shop.
    - Test this functionality.

5. Users are frustrated: they like having a body, an author, and a number of stars, but when they’re reviewing a Theater, they also want to specify which movie they saw.
    - Some reviews should now have a String movie instance variable, to hold which movie that reviewer is referencing.
    - Make sure that someone reviewing a Restaurant or a Shop doesn’t have to include which movie they saw!
    - It’s also okay if someone doesn’t want to include the movie they saw when they’re reviewing a theater (maybe they just went in for the popcorn).
    - Add testing for any new functionality you’ve created.