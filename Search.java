package myjavacode;

import java.util.*; // Import the Scanner class
import java.io.*;
import java.lang.Error;

public class Search {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object

        String input = myObj.nextLine(); // Read user input

        String[] split_input = input.split(" ");
        if (input.length() < 3) {
            System.out.println("need more arguments");
            return;
        }

        
        if (split_input[0].toLowerCase().equals("search")) {
            var regex = split_input[1];
            var file_name = split_input[2];

            // try-with-resources: Scanner will be closed automatically
            try (Scanner myReader = new Scanner(new File(file_name))) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (data.contains(regex))
                        System.out.println(data);
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}