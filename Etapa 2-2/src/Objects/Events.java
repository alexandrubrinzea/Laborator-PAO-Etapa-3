package Objects;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Events {
    private String eventName, eventType;
    private int uniqueCode, id;
    private Date startDate, endDate;
    Venue venue;

    public Events() {
    }

    //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //String stringStartDate = formatter.format(startDate);
    //String stringEndDate = formatter.format(endDate);

    public Events(String eventName, String eventType, int uniqueCode, String stringStartDate, String stringEndDate, Venue venue) throws Exception{
        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringStartDate);
       this.eventName = eventName;
       this.eventType = eventType;
       this.uniqueCode = uniqueCode;
       this.startDate = startDate;
       this.endDate = endDate;
       this.venue = venue;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public int getUniqueCode() {
        return uniqueCode;
    }



    public void AddEvent(int uniqueCode){
        Scanner cin = new Scanner(System.in);

        System.out.println("Event name ");
        eventName = cin.nextLine();
        this.eventName = eventName;

        System.out.println("Event type ");
        eventType = cin.nextLine();
        this.eventType = eventType;

        System.out.println("Unique code ");
        uniqueCode = cin.nextInt();
        this.uniqueCode = uniqueCode;

     /**
        System.out.println("Start date ");

        String date = cin.nextLine();


        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);


        this.startDate = startDate;

        System.out.println("End date ");
        endDate = cin.next();
        this.endDate = endDate;
      */
}

    public void PrintEvents(){
        System.out.println("Event name is " + this.eventName);
        System.out.println("Event type is " + this.eventType);

    }
}


