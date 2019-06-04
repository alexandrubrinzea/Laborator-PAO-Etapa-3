package Objects;

import Objects.Events;
import Objects.Venue;

import java.util.Scanner;

public class CinemaIMAX extends Events {
    private String movieTitle, Genre, Actors;
    private int ageRestriction;

    public CinemaIMAX() throws Exception{
        super();
    }

    public CinemaIMAX(String eventName, String eventType, int uniqueCode, String stringStartDate, String stringEndDate, String movietitle, String genre, int agerestriction, String actors, Venue location) throws Exception{
        super(eventName, eventType, uniqueCode, stringStartDate, stringEndDate, location);
        movieTitle = movietitle;
        Genre = genre;
        ageRestriction = agerestriction;
        Actors = actors;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void AddCinemaIMAX(int uniqueCode){
        super.AddEvent(uniqueCode);
        Scanner cin = new Scanner(System.in);

        System.out.println("The movie title is ");
        movieTitle = cin.nextLine();
        this.movieTitle = movieTitle;

        System.out.println("The actors playing are ");
        Actors = cin.nextLine();
        this.Actors = Actors;

        System.out.println("The movie genre is ");
        Genre = cin.nextLine();
        this.Genre = Genre;

        System.out.println("The age restriction is ");
        ageRestriction = cin.nextInt();
        this.ageRestriction = ageRestriction;
    }

    public void PrintCinemaIMAX(){
        super.PrintEvents();
        System.out.println("The movie title is " + this.movieTitle);
        System.out.println("The actors playing are " + this.Actors);
        System.out.println("The movie genre is " + this.Genre);
        System.out.println("The age restriction is " + this.ageRestriction);
        System.out.println();
    }
}
