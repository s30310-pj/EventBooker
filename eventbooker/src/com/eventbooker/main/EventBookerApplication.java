package com.eventbooker.main;

import com.eventbooker.booking.bookingmanager;
import com.eventbooker.event.event;
import com.eventbooker.user.UserManager;

import java.time.LocalDate;
import java.util.Scanner;

public class EventBookerApplication {
    static event event1 = new event("Opener Festival", LocalDate.now().plusDays(15), "Gdynia", 100, 750.0);
    static event event2 = new event("Clout Festival", LocalDate.now().plusDays(90), "Warszawa", 68, 650.0);
    static event event3 = new event("Concert", LocalDate.now().plusDays(20), "Kraków", 50, 100.0);
    static event event0 = null;
    static int seatNumber;
    private static UserManager userManager = new UserManager();
    private static bookingmanager bookingManager = new bookingmanager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showWelcomeScreen();
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    register(scanner);
                    break;
                case "2":
                    login(scanner);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (userManager.getLoggedInUser() != null) {
                showMainMenu(scanner);
            }
        }
    }

    private static void showWelcomeScreen() {
        System.out.println("Welcome to EventBooker");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userManager.register(username, password);
        System.out.println();
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userManager.login(username, password);
        System.out.println();
    }

    private static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Browse Events");
            System.out.println("2. Book Tickets");
            System.out.println("3. Manage Bookings");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
            System.out.println();
            switch (option) {
                case "1":
                    browseEvents();
                    break;
                case "2":
                    bookTickets(scanner);
                    break;
                case "3":
                    manageBookings();
                    break;
                case "4":
                    userManager.logout();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void browseEvents() {
        System.out.println(event1);
        System.out.println(event2);
        System.out.println(event3);
    }

    private static void bookTickets(Scanner scanner) {
        System.out.println("Enter number of the event: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                event0 = event1;
                break; 
            case "2":
                event0 = event2;
                break;
            case "3":
                event0 = event3;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        System.out.println("Booking tickets for: " + event1);
        System.out.print("Enter number of tickets: ");
        seatNumber = Integer.parseInt(scanner.nextLine());
        bookingManager.bookTicket(userManager.getLoggedInUser(), event0, seatNumber);
    }

    private static void manageBookings() {
        System.out.println("Booked events:");
        for (int i = 0; i < seatNumber; i++) {
            System.out.println(event0);
        }
        System.out.println();
    }
}
