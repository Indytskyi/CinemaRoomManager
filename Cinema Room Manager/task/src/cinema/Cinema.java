package cinema;

import java.util.Scanner;

public class Cinema {

    private final static Scanner scanner = new Scanner(System.in);
    static int rows, seats, currentRows, currentSeats, totalIncome, currentIncome, numberOgPurchasedTickets;
    static void defaultRoom(String[][] cinemaRoom) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    cinemaRoom[i][j] = " ";
                } else if (i == 0) {
                    cinemaRoom[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    cinemaRoom[i][j] = String.valueOf(i);
                } else {
                    cinemaRoom[i][j] = "S";
                }
            }
        }
        totalIncome = rows * seats < 60 ? rows * seats * 10 : rows * seats * 8 + seats * (rows / 2) * 2;
    }

    static void showTheSeats(String[][] cinemaRoom) {
        System.out.println("Cinema: ");
        for (String[] seatsInRow: cinemaRoom) {
            for(String oneSeat: seatsInRow) {
                System.out.print(oneSeat + " ");
            }
            System.out.println();
        }
    }

    static void menu() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        String[][] cinemaRoom = new String[rows + 1][seats + 1];
        defaultRoom(cinemaRoom);
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int controller = scanner.nextInt();
            switch (controller) {
                case 1 :
                    showTheSeats(cinemaRoom);
                    break;
                case 2 :
                    bookTickets(cinemaRoom);
                    break;
                case 3 :
                    statistic();
                    break;
                case 0 :
                    return;
            }

        }
    }

    static void statistic() {
        double percentageFullness = numberOgPurchasedTickets == 0 ? 0 :
                numberOgPurchasedTickets * 100 / (double)(rows * seats);
        System.out.printf("\nNumber of purchased tickets: %d \nPercentage: %.2f%s" +
                        " \nCurrent income: $%d \nTotal income: $%d\n",
                numberOgPurchasedTickets, percentageFullness,
                "%",
                currentIncome, totalIncome);
    }

    static void bookTickets(String[][] cinemaRoom) {
        System.out.println("\nEnter a row number:");
        currentRows = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        currentSeats = scanner.nextInt();
        if (currentRows > rows || currentSeats > seats) {
            System.out.println("Wrong input!");
            bookTickets(cinemaRoom);
        } else if (cinemaRoom[currentRows][currentSeats] == "B") {
            System.out.println("That ticket has already been purchased!");
            bookTickets(cinemaRoom);
        } else {
            int price =  (rows * seats < 60) ? 10 : currentRows > rows / 2 ? 8 : 10;
            System.out.println("Ticket price: $" + price + "\n");
            cinemaRoom[currentRows][currentSeats] = "B";
            currentIncome+=price;
            numberOgPurchasedTickets++;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}