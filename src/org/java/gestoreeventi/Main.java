package org.java.gestoreeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String nameInput = null;
        LocalDate dateInput = null;
        LocalTime timeInput = null;
        BigDecimal priceInput = BigDecimal.ZERO;
        int totalCapacityInput = 0;
        int numberOfBookingsInput = 0;
        Concert concert = null;

        while(!exit) {
            System.out.println("DO YOU WANT TO CREATE AN EVENT?(y/n)");
            String userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("y")) {
                System.out.println(" ");
                System.out.println("----CREATING A NEW EVENT----");

                do{
                try{
                    System.out.println("Name: ");
                    nameInput = sc.nextLine();
                    System.out.println("Date: (yyyy-mm-dd)");
                    dateInput = LocalDate.parse(sc.nextLine());
                    System.out.println("Time: (hh:mm:ss) ");
                    timeInput = LocalTime.parse(sc.nextLine());
                    System.out.println("Total Capacity: ");
                    totalCapacityInput = Integer.parseInt(sc.nextLine());
                    System.out.println("Price: ");
                    priceInput = new BigDecimal(sc.nextLine());
                    concert = new Concert(nameInput, dateInput, totalCapacityInput,timeInput,priceInput);
                  }
                  catch (DateTimeParseException e)
                  {
                      System.out.println("Correct format for dates: (yyyy-mm-dd). " +
                              "Correct format for time:(hh:mm:ss)");

                  }
                  catch (NumberFormatException e)
                  {
                      System.out.println("Incorrect format for numbers.");

                  }
                  catch (InvalidEventParametersException e)
                  {
                      System.out.println("Unable to create the event.");
                      System.out.println(e.getMessage());

                  }
                  catch(Error e)
                  {
                      System.out.println("A generic error has occurred.");
                  }

                }while(concert == null);

                System.out.println(concert);
                System.out.println("Total Capacity: " + concert.getTotalCapacity());

                while(!exit) {

                System.out.println("WHAT WOULD YOU LIKE TO DO? ");
                System.out.println("1.BOOK ONE OR MORE SEATS.");
                System.out.println("2.CANCEL ONE OR MORE RESERVATIONS.");
                System.out.println("3.EXIT.");
                String menuChoice = sc.nextLine();

                switch(menuChoice)
                {
                    case "1":
                        try{
                        System.out.println("Add number of bookings: ");
                        numberOfBookingsInput = Integer.parseInt(sc.nextLine());
                        concert.book(numberOfBookingsInput);
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Insert a number.");
                        }
                        catch (InvalidEventParametersException e)
                        {
                            System.out.println(e.getMessage());

                        }
                        catch(Error e)
                        {
                            System.out.println("A generic error has occurred.");
                        }
                        System.out.println("Total number of bookings: "+concert.getNumberOfBookings());
                        System.out.println("Remaining seats: "+concert.getRemainingSeats());
                        break;

                    case "2":
                        try{
                        System.out.println("Add number of bookings you want to cancel: ");
                        numberOfBookingsInput = Integer.parseInt(sc.nextLine());
                        concert.cancelReservation(numberOfBookingsInput);
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Insert a number.");
                        }
                        catch (InvalidEventParametersException e)
                        {
                            System.out.println(e.getMessage());
                        }
                        catch(Error e)
                        {
                            System.out.println("A generic error has occurred.");
                        }

                        System.out.println("Remaining seats: "+concert.getRemainingSeats());
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

                System.out.println("Insert y or n.");

            }

        }

        System.out.println("HOPE YOU ENJOYED OUR APP! BYE BYE!");

        sc.close();
    }

}
