package Objects;

import Objects.Events;

import java.lang.String;
import java.util.Scanner;

public class TheatrePlays extends Events {
    private String Title, Director, Actors, Adaptation;


    public TheatrePlays() throws Exception{
        super();
    }

    public TheatrePlays(String eventName, String eventType, int uniqueCode, String stringStartDate, String stringEndDate, String title, String director, String actors, String adaptation, Venue location) throws Exception{
        super(eventName, eventType, uniqueCode, stringStartDate, stringEndDate, location);
        Title = title;
        Director = director;
        Actors = actors;
        Adaptation = adaptation;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getAdaptation() {
        return Adaptation;
    }

    public void setAdaptation(String adaptation) {
        Adaptation = adaptation;
    }

    public void AddTheatrePlays(int uniqueCode){
        super.AddEvent(uniqueCode);
        Scanner cin = new Scanner(System.in);

        System.out.println("Title ");
        Title = cin.nextLine();
        this.Title = Title;

        System.out.println("Director ");
        Director = cin.nextLine();
        this.Director = Director;

        System.out.println("Actors ");
        Actors = cin.nextLine();
        this.Actors = Actors;

        System.out.println("Adaptation ");
        Adaptation = cin.nextLine();
        this.Adaptation = Adaptation;
    }

    public void PrintTheatrePlays(){
        super.PrintEvents();
        System.out.println("The title is " + this.Title);
        System.out.println("The director is " + this.Director);
        System.out.println("The actors are " + this.Actors);
        System.out.println("This is an adaptation from " + this.Adaptation);
        System.out.println();
    }
}
