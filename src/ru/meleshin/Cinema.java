package ru.meleshin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        String[][] cinema = buildCinema();
        printCinema(cinema);
        takeSeat(cinema);
        printCinema(cinema);
    }

    private static String[][] buildCinema() {
        int rows = 0;
        int columns = 0;

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println();
                System.out.println("Enter the number of rows: ");
                rows = scanner.nextInt() + 1;
                System.out.println("Enter the number of seats in a row: ");
                columns = scanner.nextInt() + 1;
                break;
            } catch (InputMismatchException ex) {
                System.out.println("You entered not a number!");
            }
        }

        int count = 1;
        String[][] cinema = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 & j == 0) {
                    cinema[i][j] = " ";
                    continue;
                }
                if (i == 0 || j == 0) {
                    cinema[i][j] = String.valueOf(count);
                    count++;
                    if (i == 0 & j == columns - 1) count = 1;
                } else {
                    cinema[i][j] = "S";
                }
            }
        }
        return cinema;
    }

    private static void takeSeat(String[][] cinema) {
        int row = 0;
        int sitting = 0;
        while (true) {
            try {
                System.out.println();
                System.out.println("Enter row number: ");
                Scanner scanner1 = new Scanner(System.in);
                row = scanner1.nextInt();
                System.out.println("Enter the seat number: ");
                sitting = scanner1.nextInt();
                cinema[row][sitting] = "B";
                break;
            } catch (InputMismatchException ex) {
                System.out.println("You entered not a number!");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("There is no such seat!");
            }
        }

        if (cinema.length * cinema[0].length > 60) System.out.println("Ticket price 10$");
        else System.out.println("Ticket price 8$");
    }

    private static void printCinema(String[][] cinema) {
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


