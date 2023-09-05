package org.java.gestoreeventi;

import java.time.LocalDate;

public class Event {

    private String nameOfTheEvent;
    private LocalDate date;
    private int totalCapacity;
    private int numberOfBookings;

    public Event(String nameOfTheEvent, LocalDate date, int totalCapacity) {
        this.nameOfTheEvent = nameOfTheEvent;
        this.date = checkValidityOfDate(date);
        this.totalCapacity = checkValidityOfCapacity(totalCapacity);
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


    public void book(int userBookingsToAdd) throws Exception
    {
         if(LocalDate.now().isAfter(date) || numberOfBookings == totalCapacity)
         {
             throw new Exception("An error has occurred. The Event is already over or total capacity has been reached.");

         }


        numberOfBookings++;

    }


    public void cancelReservation(int userBookingsToDelete) throws Exception
    {
        if(LocalDate.now().isAfter(date) || numberOfBookings == 0)
        {
            throw new Exception("An error has occurred. The Event is already over or couldn't find any previous bookings.");

        }


        numberOfBookings--;



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
                "  name of the event='" + nameOfTheEvent + '\'' +
                ", date=" + date +
                '}';
    }
}
