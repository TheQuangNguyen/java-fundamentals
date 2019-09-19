/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
//        File gatesJs = new File(String.format("src/main/resources/gates.js"));
//        File noErrors = new File("src/main/resources/noErrors.js");
//        File oneError = new File("src/main/resources/oneError.js");
//        File fewErrors = new File("src/main/resources/fewErrors.js");
//        File empty = new File("src/main/resources/empty.js");
        File fileToLint = new File(String.format("src/main/resources/%s", args[0]));
//        jsLinter(gatesJs);
//        jsLinter(noErrors);
//        jsLinter(oneError);
//        jsLinter(fewErrors);
//        jsLinter(empty);
        jsLinter(fileToLint);
    }


    // Write a method that reads a JavaScript file with a given Path,
    // and generates an error message whenever it finds a line that doesn’t end in a semi-colon.

    public static String jsLinter(File jsFile) {
        String errorMessage = "";
        try {
            Scanner reader = new Scanner(jsFile);
            int lineNumber = 0;
            while (reader.hasNextLine()) {
                String lineOfCode = reader.nextLine();
                lineNumber++;
//                if (!lineOfCode.contains("if") && !lineOfCode.contains("else") &&
//                    !lineOfCode.endsWith("}") && !lineOfCode.endsWith("{") &&
//                    !lineOfCode.isBlank() && !lineOfCode.contains("//")) {
                if (!lineOfCode.isBlank() && !lineOfCode.startsWith("//")) {
                    if (!lineOfCode.contains("else")) {
                        if (!lineOfCode.contains("if")) {
                            if (!lineOfCode.endsWith("{") && !lineOfCode.endsWith("}")) {
                                if (!lineOfCode.endsWith(";")) {
                                    System.out.println(String.format("Line %d: Missing semicolon", lineNumber));
                                    errorMessage = errorMessage + String.format("Line %d: Missing semicolon\n", lineNumber);
                                }
                                if (lineOfCode.contains("\"")) {
                                    System.out.println(String.format("Line %d: Use single quote, not double quotes", lineNumber));
                                    errorMessage = errorMessage + String.format("Line %d: Use single quote, not double quotes\n", lineNumber);
                                }
                            } else {
                                Pattern regex = Pattern.compile("\\{[a-zA-Z\\s,\\.0-9]*\\}");
                                Matcher matcher = regex.matcher(lineOfCode);
                                if (matcher.find()) {
                                    if (!lineOfCode.endsWith(";")) {
                                        System.out.println(String.format("Line %d: Missing semicolon", lineNumber));
                                        errorMessage = errorMessage + String.format("Line %d: Missing semicolon\n", lineNumber);
                                    }
                                }
                            }
                        } else {
                            if (lineOfCode.contains("\"")) {
                                System.out.println(String.format("Line %d: Use single quote, not double quotes", lineNumber));
                                errorMessage = errorMessage + String.format("Line %d: Use single quote, not double quotes\n", lineNumber);
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("JS file was not found");
        }
        return errorMessage;
    }
}
