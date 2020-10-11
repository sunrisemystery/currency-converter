package com.joannagajzler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Positions positionsList;
    private Conversion convert = new Conversion();

    public UserInterface(Positions positionsList) {
        this.positionsList = positionsList;
    }

    public void showAll() {
        System.out.println("List of available currencies:\n");
        int i = 0;
        System.out.format("%-39s | %s\n", "Currency Name", "Currency Code");
        System.out.println("--------------------------------------------------------");
        for (Position pos : positionsList.getPositionList()) {
            if (i < 10) {
                System.out.println(i + ".  " + pos.toString());
            } else {
                System.out.println(i + ". " + pos.toString());
            }
            i++;
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int choice = -1;
        int inputCurrency = -1;
        int outputCurrency = -1;
        double amount;
        while (!quit) {
            try {
                System.out.println("Chosen input currency: " + positionsList.getPositionByIndex(inputCurrency).getCurrencyName());

            } catch (NullPointerException e) {
                System.out.println("Chosen input currency: none");
            }
            try {
                System.out.println("Chosen output currency: " + positionsList.getPositionByIndex(outputCurrency).getCurrencyName());
            } catch (NullPointerException e) {
                System.out.println("Chosen output currency: none");
            }

            System.out.println("\nChoose an action:\n\n" +
                    "1. Show all currencies\n" +
                    "2. Choose input currency\n" +
                    "3. Choose output currency\n" +
                    "4. Convert\n" +
                    "6. Quit");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Type an integer");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    showAll();
                    break;

                case 2:
                    showAll();
                    System.out.println("Choose a number from a list:\n");
                    try {
                        inputCurrency = scanner.nextInt();
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Chosen number is wrong.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    showAll();
                    System.out.println("Choose a number from a list:\n");
                    try {
                        outputCurrency = scanner.nextInt();
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Chosen number is wrong.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Choose an amount of money to convert:");
                        System.out.print(positionsList.getPositionByIndex(inputCurrency).getCurrencyCode() + ": ");
                        amount = scanner.nextDouble();
                        System.out.println(amount + " " + positionsList.getPositionByIndex(inputCurrency).getCurrencyCode() + " -> " +
                                convert.convert(positionsList.getPositionByIndex(inputCurrency), positionsList.getPositionByIndex(outputCurrency), amount) + " " +
                                positionsList.getPositionByIndex(outputCurrency).getCurrencyCode());
                    } catch (NullPointerException e) {
                        System.out.println("Input/output currency haven't been chosen");
                    }
                    break;

                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Choose a number from 1 to 5");
            }
        }
    }
}