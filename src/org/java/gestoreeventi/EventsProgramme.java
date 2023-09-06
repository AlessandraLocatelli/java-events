package org.java.gestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsProgramme {

    String programmeTitle;
    List<Event> eventsList;

    public String getProgrammeTitle() {
        return programmeTitle;
    }

    public void setProgrammeTitle(String programmeTitle) {
        this.programmeTitle = programmeTitle;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }


    public EventsProgramme(String programmeTitle) {
        this.programmeTitle = programmeTitle;
        eventsList = new ArrayList<>();
    }


    //metodo aggiungi evento alla lista
    public void addEvent(Event event)
    {
        eventsList.add(event);

    }


    //metodo restituisci lista con tutti gli eventi presenti in una certa data
    public List<Event> showMeEventsAtAGivenDate(LocalDate date)
    {
        List<Event> eventsWithSameDateList = new ArrayList<>();


        for( int i = 0; i < eventsList.size(); i++)
        {
            if(date.equals(eventsList.get(i).getDate()))
            {
                eventsWithSameDateList.add(eventsList.get(i));
            }

        }

        return eventsWithSameDateList;
    }


    //metodo restituisci numero eventi presenti nel programma
    public int showMeNumberOfEvents()
    {

        return eventsList.size();
    }


    //metodo svuota lista degli eventi
    public void clearEventsList()
    {

        eventsList.clear();
    }


    //metodo restituisci stringa mostrando titolo del programma e tutti gli eventi
    public String toString()
    {

        return " Title: "+programmeTitle+
                " Events: "+eventsList;


    }

}
