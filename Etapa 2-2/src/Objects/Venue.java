package Objects;

public class Venue {
    private String location;
    private int capacity;
    private boolean openAir, seated;

    public Venue() {
    }

    public Venue(String location, int capacity, boolean openAir, boolean seated) {
        this.location = location;
        this.capacity = capacity;
        this.openAir = openAir;
        this.seated = seated;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOpenAir() {
        return openAir;
    }

    public boolean isSeated() {
        return seated;
    }
}
