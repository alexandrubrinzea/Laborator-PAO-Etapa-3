package Objects;

import Objects.Events;
import Objects.Venue;

import java.util.Scanner;

public class ArtGalleries extends Events {
    private String expositionType, artistName;

    public ArtGalleries() throws Exception{
        super();
    }

    public ArtGalleries(String eventName, String eventType, int uniqueCode, String stringStartDate, String stringEndDate, String artist, String exposition, Venue location) throws Exception{
        super(eventName, eventType, uniqueCode, stringStartDate, stringEndDate, location);
        artistName = artist;
        expositionType = exposition;
    }

    public String getExpositionType() {
        return expositionType;
    }

    public void setExpositionType(String expositionType) {
        this.expositionType = expositionType;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void AddArtGalleries(int uniqueCode){
        super.AddEvent(uniqueCode);
        Scanner cin = new Scanner(System.in);

        System.out.println("Artist ");
        artistName = cin.nextLine();
        this.artistName = artistName;

        System.out.println("Exposition ");
        expositionType = cin.nextLine();
        this.expositionType = expositionType;
    }

    public void PrintArtGalleries(){
        super.PrintEvents();
        System.out.println("The artist is " + this.artistName);
        System.out.println("The exposition is named " + this.expositionType);
        System.out.println();
    }
}
