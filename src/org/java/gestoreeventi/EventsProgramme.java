package org.java.gestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsProgramme {

    String programmeTitle;
    List<Event> eventsList;



    public EventsProgramme(String programmeTitle) throws InvalidEventParametersException {

        if(Utilities.isEmptyString(programmeTitle))
        {
            throw new InvalidEventParametersException("Title cannot be null or empty.");
        }

        this.programmeTitle = programmeTitle;
        eventsList = new ArrayList<>();


    }



    public String getProgrammeTitle() {
        return programmeTitle;
    }

    public void setProgrammeTitle(String programmeTitle) throws InvalidEventParametersException {

        if(Utilities.isEmptyString(programmeTitle))
        {
            throw new InvalidEventParametersException("Title cannot be null or empty.");
        }

        this.programmeTitle = programmeTitle;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }


    public void addEvent(Event event)
    {
        eventsList.add(event);

    }



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

        if(eventsWithSameDateList.isEmpty())
        {
            System.out.println("No events staring on: "+date);
        }

        return eventsWithSameDateList;
    }


    public int showMeNumberOfEvents()
    {

        return eventsList.size();
    }


    public void clearEventsList()
    {

        eventsList.clear();
    }

    public String toString()
    {

        return " Title: "+programmeTitle+
                " Events: "+eventsList;


    }

}
