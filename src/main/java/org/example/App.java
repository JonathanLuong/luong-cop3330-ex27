package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 27 Solution
 *  Copyright 2021 Jonathan Luong
 */


import java.util.Scanner;
import java.util.regex.*;


public class App {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Creates reader

        System.out.printf("Enter the first name: ");
        String fName = reader.nextLine();
        System.out.printf("Enter the last name: ");
        String lName = reader.nextLine();
        System.out.printf("Enter the ZIP code: ");
        String zip = reader.nextLine();
        System.out.printf("Enter the employee ID: ");
        String empID = reader.nextLine();

        validateInput(fName, lName, zip, empID);
    }

    static int validateFirstName(String fName) {
        return fName.length();
    }

    static int validateLastName(String lName) {
        return lName.length();
    }

    static boolean validateZip(String zip) {

        if(zip.length() != 5)
            return false;

        if (zip == null) {
            return false;
        }
        try {    // Tries to convert the string to an int
            int d = Integer.parseInt(zip);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static boolean validateEmpID(String empID) {
        char arr[] = empID.toCharArray();

        if(empID.length() != 7)
            return false;

        for(int i = 0; i < 2; i++) {
            if ((arr[i] >= '1' && arr[i] >= '9' ))
                return false;
        }

        if(arr[2] != '-')
            return false;

        for(int i = 0; i < 4; i++) {
            if (arr[i+3] >= 'A' && arr[i+3] >= 'Z' )
                return false;
        }

        return true;
    }

    static void validateInput(String fName, String lName, String zip, String empID) {
        int tick = 0; // Counts num of errors

        if(validateFirstName(fName) == 0) {
            System.out.println("The first name must be filled in.\n");
            tick++;
        }
        else if(validateFirstName(fName) == 1) {
            System.out.println("The first name must be at least 2 characters long.\n");
            tick++;
        }

        if(validateLastName(lName) == 0) {
            System.out.println("The last name must be filled in.\n");
            tick++;
        }
        else if(validateLastName(lName) == 1) {
            System.out.println("The last name must be at least 2 characters long.\n");
            tick++;
        }

        if(validateZip(zip) != true) {
            System.out.println("The zipcode must be a 5 digit number.\n");
            tick++;
        }

        if(validateEmpID(empID) != true) {
            System.out.println("The employee ID must be in the format of AA-1234.\n");
            tick++;
        }

        if(tick == 0)
            System.out.println("There were no errors found.\n");
    }
}