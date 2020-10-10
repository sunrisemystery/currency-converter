package com.joannagajzler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Positions positionsList;
    private Conversion convert = new Conversion();

    public View(Positions positionsList) {
        this.positionsList = positionsList;
    }

    public void showAll() {
        System.out.println("List of available currencies:\n");
        int i = 0;
        for (Position pos : positionsList.getPositionList()) {
            System.out.println(i + ". " + pos.toString());
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
            System.out.println("Choose an action:\n\n" +
                    "1. Show all currencies\n" +
                    "2. Choose input currency\n" +
                    "3. Choose output currency\n" +
                    "4. Convert\n" +
                    "5. Show my choices\n" +
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
                    System.out.println("Choose a number from a list:\n");
                    showAll();
                    try {
                        inputCurrency = scanner.nextInt();
                        System.out.println("Chosen input currency: " + positionsList.getPositionByIndex(inputCurrency).getCurrencyName());
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Chosen number is wrong.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("Choose a number from a list:\n");
                    showAll();
                    try {
                        outputCurrency = scanner.nextInt();
                    } catch (InputMismatchException | NullPointerException e) {
                        System.out.println("Chosen number is wrong.");
                        scanner.nextLine();
                    }
                    System.out.println("Chosen output currency: " + positionsList.getPositionByIndex(outputCurrency).getCurrencyName());
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
                    try {
                        System.out.println("Chosen input currency: " + positionsList.getPositionByIndex(inputCurrency).getCurrencyName());
                        System.out.println("Chosen output currency: " + positionsList.getPositionByIndex(outputCurrency).getCurrencyName());
                    } catch (NullPointerException e) {
                        System.out.println("Input/output currency haven't been chosen");

                    }
                    break;

                case 6:
                    quit = true;
                    break;

                default:
                    System.out.println("Choose a number from 1 to 6");
            }
        }
    }
}
