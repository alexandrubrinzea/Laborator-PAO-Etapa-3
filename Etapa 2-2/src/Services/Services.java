package Services;

import Objects.ArtGalleries;
import Objects.Concerts;
import Objects.Events;

import java.util.ArrayList;
import java.util.List;

public class Services {
    private List<Events> listOfEvents;

    private static Services services = new Services();

    public Services() {
        listOfEvents = new ArrayList<Events>();
    }

    public static Services getService() {
        return services;
    }

    public List<Concerts> getConcerts() throws Exception{
        List<Concerts> concerts = new ArrayList<Concerts>();

        for (Events event : listOfEvents)
            if (event instanceof Concerts)
                concerts.add((Concerts) event);
        return concerts;
    }

    public static void setServices(Services services) {
        Services.services = services;
    }

    public void setListOfEvents(List<Events> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }

    public void printConcerts(List<Concerts> allConcerts){
        int counter = 1;
        for (Concerts event : allConcerts) {
            System.out.println(counter + ". " + event.getEventName());
            counter++;
        }
    }

    public List<ArtGalleries> getArtGalleries() throws Exception{
        List<ArtGalleries> artgalleries = new ArrayList<ArtGalleries>();

        for (Events event : listOfEvents)
            if (event instanceof ArtGalleries)
                artgalleries.add((ArtGalleries) event);
        return artgalleries;
    }

    public void printAllGalleries(List<ArtGalleries> allArtGalleries) {
        int counter = 1;
        for (ArtGalleries event : allArtGalleries) {
            System.out.println(counter + ". " + event.getEventName());
            counter++;
        }
    }

}
