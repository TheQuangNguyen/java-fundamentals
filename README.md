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

[Code Solution to First Two Problems]()

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

[Code For JS linter]()

Write a method that reads a JavaScript file with a given Path, and generates an error message whenever it finds a line that doesn’t end in a semi-colon.

Read through the file line by line. Create a string that contains a message such as "Line 3: Missing semicolon." if a line is missing a semicolon.

Don’t show an error if the line is empty.
Don’t show an error if the line ends with an opening curly brace {
Don’t show an error if the line ends with an closing curly brace }
Don’t show an error if the line contains if or else

