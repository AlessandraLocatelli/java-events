package org.java.gestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Event {

    private String nameOfTheEvent;
    private LocalDate date;
    private int totalCapacity;
    private int numberOfBookings;

    public Event(String nameOfTheEvent, LocalDate date, int totalCapacity) throws InvalidEventParametersException {

        boolean invalid = Utilities.isDateInThePast(date) || Utilities.isNotPositiveNumber(totalCapacity) || Utilities.isEmptyString(nameOfTheEvent);

        if(invalid)
        {
            List<String> messages = new ArrayList<>();

            if(Utilities.isDateInThePast(date))
            {
                messages.add("the event cannot start in the past");
            }

            if(Utilities.isNotPositiveNumber(totalCapacity))
            {
                messages.add("total capacity can't be equal to or less than zero!");
            }

            if(Utilities.isEmptyString(nameOfTheEvent))
            {
                messages.add("name of the event cannot be empty or null.");
            }

            throw new InvalidEventParametersException(String.join("," ,messages));

        }


        this.nameOfTheEvent = nameOfTheEvent;
        this.date = date;
        this.totalCapacity = totalCapacity;
        this.numberOfBookings = 0;
    }


    public String getNameOfTheEvent() {
        return nameOfTheEvent;
    }

    public void setNameOfTheEvent(String nameOfTheEvent) throws InvalidEventParametersException {
        if (Utilities.isEmptyString(nameOfTheEvent))
        {
            throw new InvalidEventParametersException("name can't be null or empty.");
        }
        this.nameOfTheEvent = nameOfTheEvent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws InvalidEventParametersException {
        if(Utilities.isDateInThePast(date))
        {
            throw new InvalidEventParametersException("the event cannot start in the past!");
        }
        this.date = date;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public int getRemainingSeats() {

        return totalCapacity-numberOfBookings;
    }



    public void book(int userBookingsToAdd) throws InvalidEventParametersException
    {
         if(getRemainingSeats() < userBookingsToAdd)
         {
             throw new InvalidEventParametersException( "not enough available seats.");

         }

         if(Utilities.isDateInThePast(this.date))
         {
             throw new InvalidEventParametersException("the event is already over.");

         }

         numberOfBookings += userBookingsToAdd;

    }


    public void cancelReservation(int userBookingsToDelete) throws InvalidEventParametersException
    {
        if(numberOfBookings < userBookingsToDelete)
        {
            throw new InvalidEventParametersException("you indicated a number greater than the number of seats you previously booked. ");
        }

        if(Utilities.isDateInThePast(this.date))
        {
            throw new InvalidEventParametersException("the event is already over.");

        }


        numberOfBookings -=  userBookingsToDelete;

    }


    @Override
    public String toString() {
        return "Event{" +
                " name of the event='" + nameOfTheEvent + '\'' +
                " ,date=" + date +
                '}';
    }
}
