package org.java.gestoreeventi;

import java.time.LocalDate;

public class Event {

    private String nameOfTheEvent;
    private LocalDate date;
    private int totalCapacity;
    private int numberOfBookings;

    private int remainingSeats;

    public Event(String nameOfTheEvent, LocalDate date, int totalCapacity) {
        this.nameOfTheEvent = nameOfTheEvent;
        this.date = checkValidityOfDate(date);
        this.totalCapacity = checkValidityOfCapacity(totalCapacity);
        this.remainingSeats = totalCapacity;
        numberOfBookings = 0;
    }


    public String getNameOfTheEvent() {
        return nameOfTheEvent;
    }

    public void setNameOfTheEvent(String nameOfTheEvent) {
        this.nameOfTheEvent = nameOfTheEvent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = checkValidityOfDate(date);
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public int getRemainingSeats()
    {

        return remainingSeats;

    }


    public void book(int userBookingsToAdd) throws RuntimeException
    {
         if(LocalDate.now().isAfter(date) || numberOfBookings == totalCapacity)
         {
             throw new RuntimeException("An error has occurred. The Event is already over or total capacity has been reached.");

         }


        numberOfBookings = numberOfBookings+userBookingsToAdd;

    }


    public void cancelReservation(int userBookingsToDelete) throws RuntimeException
    {
        if(LocalDate.now().isAfter(date) || numberOfBookings == 0)
        {
            throw new RuntimeException("An error has occurred. The Event is already over or couldn't find any previous bookings.");

        }


        numberOfBookings = numberOfBookings - userBookingsToDelete;



    }

    public void updateRemainingSeats()
    {

        remainingSeats = totalCapacity - numberOfBookings;

    }


    private LocalDate checkValidityOfDate(LocalDate date) throws RuntimeException
    {
        if(date.isBefore(LocalDate.now()))
        {

            throw new RuntimeException("The event cannot start in the past!");

        }

        return date;

    }

    private int checkValidityOfCapacity(int totalCapacity) throws IllegalArgumentException
    {
        if(totalCapacity <= 0)
        {

            throw  new IllegalArgumentException("Total capacity can't be equal to or less than zero!");

        }

          return totalCapacity;
    }


    @Override
    public String toString() {
        return "Event{" +
                " name of the event='" + nameOfTheEvent + '\'' +
                " ,date=" + date +
                '}';
    }
}
