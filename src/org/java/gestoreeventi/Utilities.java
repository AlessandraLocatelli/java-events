package org.java.gestoreeventi;

import java.time.LocalDate;

public class Utilities {

    //per non permettere di istanziare la classe, creo un costruttore private
    private Utilities()
    {


    }
        public static boolean isEmptyString(String s)
        {
            return s == null || s.isEmpty();

        }

        public static boolean isNotPositiveNumber(int n)
        {
            return n <= 0;
        }

        public static boolean isDateInThePast(LocalDate date)
        {
            return date.isBefore(LocalDate.now());

        }


}
