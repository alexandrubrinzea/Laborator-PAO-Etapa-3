package Objects;

import Objects.Events;

import java.lang.String;
import java.util.Scanner;

public class Concerts extends Events {
    private String Artists;
    private String Tour;

    public Concerts() throws Exception{
        super();
    }

    public Concerts(String eventName, String eventType, int uniqueCode, String stringStartDate, String stringEndDate, String artists, String tour, Venue location) throws Exception{
        super(eventName, eventType, uniqueCode, stringStartDate, stringEndDate, location);
        Artists = artists;
        Tour = tour;
    }

    public String getTour() {
        return Tour;
    }

    public void setTour(String tour) {
        Tour = tour;
    }

    public void AddConcert(int uniqueCode){
        super.AddEvent(uniqueCode);
        Scanner cin = new Scanner(System.in);

        System.out.println("Artists ");
        Artists = cin.nextLine();
        this.Artists = Artists;

        System.out.println("Tour ");
        Tour = cin.nextLine();
        this.Tour = Tour;
    }

    public void PrintConcerts(){
        super.PrintEvents();
        System.out.println("Artists are " + this.Artists);
        System.out.println("The tour is named " + this.Tour);
        System.out.println();
    }
}
