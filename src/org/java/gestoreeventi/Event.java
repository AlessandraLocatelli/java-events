package org.java.gestoreeventi;

import java.time.LocalDate;

/*con remaining seats si intende indicare qualsiasi tipologia di posto rimanente, inclusi, ma non solo,
i posti a sedere*/

public class Event {

    private String nameOfTheEvent;
    private LocalDate date;
    private int totalCapacity; //totale posti disponibili
    private int numberOfBookings; //numero prenotazioni

    private int remainingSeats; //posti disponibili rimanenti

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

    public int getRemainingSeats() {return remainingSeats;}


    //metodo per aggiungere nuove prenotazioni
    public void book(int userBookingsToAdd) throws RuntimeException
    {
         if(userBookingsToAdd < 0 || numberOfBookings == totalCapacity)
         {
             throw new RuntimeException("Opss... One between the following errors has just occurred: you either tried to add a negative number or total capacity has already been reached.");

         }


        numberOfBookings = numberOfBookings+userBookingsToAdd;

    }

    //metodo per cancellare prenotazioni
    public void cancelReservation(int userBookingsToDelete) throws RuntimeException
    {
        if( userBookingsToDelete < 0  || numberOfBookings == 0 || numberOfBookings < userBookingsToDelete)
        {
            throw new RuntimeException("Opss... One between the following errors has just occurred: you tried to add a negative number, you didn't previously book any seats or you" +
                    " indicated a number greater than the number of seats you previously booked. ");

        }


        numberOfBookings = numberOfBookings - userBookingsToDelete;



    }

    //metodo per aggiornare posti rimanenti
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
