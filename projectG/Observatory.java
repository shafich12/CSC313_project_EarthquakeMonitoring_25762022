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

    public int getHighestColourValue(){
        int max = 0;
        for (Galamsey galamsey : galamseyEvents) {
            if(galamsey.getColourValue() >= max){
                max = galamsey.getColourValue();
            }
        }
        return max;
    }

    public float getAverageColourValue(){
        int sum = 0;
        int count = 0;

        for (Galamsey galamsey : galamseyEvents) {
            sum = sum + galamsey.getColourValue();
            count++;
        }
        return sum/count;
    }

    public List<Galamsey> getAllEvents(int value){

        List<Galamsey> largerThan = new ArrayList<>();

        for(Galamsey galamsey: galamseyEvents){
            if(galamsey.getColourValue() > value){
                largerThan.add(galamsey);
            }
        }

        return largerThan;
    }

    public static void main(String[] args) {
        Position accra = new Position(2.5, 3.6);

        Observatory observe = new Observatory();
        observe.createEvent(Galamsey.colour.green, 1, accra, 2005);
        observe.createEvent(Galamsey.colour.green, 3, accra, 2005);
        observe.createEvent(Galamsey.colour.green, 2, accra, 2005);
        observe.createEvent(Galamsey.colour.green, 3, accra, 2005);
        observe.createEvent(Galamsey.colour.green, 1, accra, 2005);

        //observe.viewEvents();
        // System.out.println(observe.getHighestColourValue());
        // System.out.println(observe.getAverageColourValue());

        for (Galamsey e : observe.getAllEvents(0)) {
            System.out.println(e.getColourValue());
            
        }

    }
}