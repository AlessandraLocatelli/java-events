package org.java.gestoreeventi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {

    LocalTime time;
    BigDecimal price;

    public Concert(String nameOfTheEvent, LocalDate date, int totalCapacity, LocalTime time, BigDecimal price) throws InvalidEventParametersException {

        super(nameOfTheEvent, date, totalCapacity);

        if (price.signum() <= 0)
        {
            throw new InvalidEventParametersException("Price cannot be negative or equal to zero.");
        }
        this.price = price;
        this.time = time;


    }


    public LocalTime getTime()
    {return time;}

    public void setTime(LocalTime time)
    {this.time = time;}

    public BigDecimal getPrice()
    {return price;}

    public void setPrice(BigDecimal price) throws InvalidEventParametersException
    {
        if (price.signum() <= 0)
        {
            throw new InvalidEventParametersException("Price cannot be negative or equal to zero.");
        }

        this.price = price;
    }


    //metodo per formattare date e ora assieme
    public LocalDateTime getDateTimeFormat()
    {

        LocalDateTime dateTimeWithFormat = getDate().atTime(time);
        return dateTimeWithFormat;

    }

    //metodo per formattare il prezzo

    public String getPriceFormat()
    {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String priceWithFormat = currencyFormat.format(price);

        return priceWithFormat;

    }


    public String toString()
    {

        return " name of the event: "+getNameOfTheEvent()+
                " ,date and time: "+getDateTimeFormat()+
                " ,price: "+getPriceFormat();

    }

}


