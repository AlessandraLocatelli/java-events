package org.java.gestoreeventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String nameInput = null;
        LocalDate dateInput = null;
        int totalCapacityInput = 0;
        int numberOfBookingsInput = 0;
        Event event = null;

        while(event == null && !exit) {
            System.out.println("DO YOU WANT TO CREATE AN EVENT?(y/n)");
            String userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("y"))
            {
                System.out.println("----CREATING A NEW EVENT----");
                System.out.println("Name: ");
                nameInput = sc.nextLine();
                System.out.println("Date: (yyyy-mm-dd)");
                dateInput = LocalDate.parse(sc.nextLine());
                System.out.println("Total Capacity: ");
                totalCapacityInput = Integer.parseInt(sc.nextLine());
                event = new Event(nameInput,dateInput,totalCapacityInput);
                System.out.println(event);
                System.out.println("Total Capacity: "+event.getTotalCapacity());

                while(!exit) {

                System.out.println("WHAT WOULD YOU LIKE TO DO? ");
                System.out.println("1.BOOK ONE OR MORE SEATS.");
                System.out.println("2.CANCEL ONE OR MORE RESERVATIONS.");
                System.out.println("3.EXIT");
                userChoice = sc.nextLine();

                switch(userChoice)
                {
                    case "1":
                        System.out.println("Add number of bookings: ");
                        numberOfBookingsInput = Integer.parseInt(sc.nextLine());
                        event.book(numberOfBookingsInput);
                        System.out.println("Total number of bookings: "+event.getNumberOfBookings());
                        event.updateRemainingSeats();
                        System.out.println("Remaining seats: "+event.getRemainingSeats());
                        break;

                    case "2":
                        System.out.println("Add number of bookings you want to cancel: ");
                        numberOfBookingsInput = Integer.parseInt(sc.nextLine());
                        event.cancelReservation(numberOfBookingsInput);
                        event.updateRemainingSeats();
                        System.out.println("Remaining seats: "+event.getRemainingSeats());
                        break;

                    case "3":
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;


                }
                }


            }
            else if(userChoice.equalsIgnoreCase("n"))
            {
                exit = true;

            }
            else
            {

                System.out.println("Insert y or n ");

            }

        }

        System.out.println("HOPE YOU ENJOYED OUR APP! BYE BYE!");

        sc.close();
    }

}
