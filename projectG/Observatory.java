import java.time.Year;
import java.util.ArrayList;
import java.util.List;

// import Galamsey.Location;
// import Galamsey.colour;
public class Observatory {
    private String observatoryName;
    private String countryName;
    private int areaCovered;
    private List<Galamsey> galamseyEvents;
    private int yearStarted;

    public Observatory(){
        galamseyEvents = new ArrayList<>();
    }

    

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public void setAreaCovered(final int areaCovered) {
        this.areaCovered = areaCovered;
    }


    // public class GalamseyEvents {
    //     public galamsey(colour vegetationColour, int colourValue, Location location) {
    //         this.vegetationColour = vegetationColour;
    //         this.colourValue = colourValue;
    //         this.location = location;

    //         if(vegetationColour == yellow || vegetationColour == brown){
    //             galamseyEvents.add(location);
    //         }
    //     }
    // }



    public String getObservatoryName() {
        return observatoryName;
    }

    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getAreaCovered() {
        return areaCovered;
    }

    public List<Galamsey> getGalamseyEvents() {
        return galamseyEvents;
    }

    public void setGalamseyEvents(List<Galamsey> galamseyEvents) {
        this.galamseyEvents = galamseyEvents;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public void createEvent(Galamsey.colour vegetationColour, int colourValue, Position position, int year){
        Galamsey newEvent = new Galamsey(vegetationColour, colourValue, position, year);
        galamseyEvents.add(newEvent);
    }

    public void viewEvents(){
        for (Galamsey galamsey : galamseyEvents) {
            System.out.println(galamsey.getColourValue());
        }
    }

    public static void main(String[] args) {
        Position accra = new Position(2.5, 3.6);

        Observatory observe = new Observatory();
        observe.createEvent(Galamsey.colour.green, 1, accra, 2005);
        observe.viewEvents();
    }
}