import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public class Observatory {
    private String observatoryName;
    private String countryName;
    private int areaCovered;
    private List<Galamsey> galamseyEvents;
    private int yearStarted;

    public Observatory(String observatoryName, String countryName, int areaCovered, int yearStarted){
        this.observatoryName = observatoryName;
        this.countryName = countryName;
        this.areaCovered = areaCovered;
        this.yearStarted = yearStarted;

        galamseyEvents = new ArrayList<>();
        Monitoring.observatories.add(this);
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
        float sum = 0;
        float count = 0;

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

    @Override
    // public String toString() {
    //     return  "Observatory Name         : " + observatoryName +
    //             "\nCountry Name             : " + countryName +
    //             "\nArea Covered (in sq. km) : " + areaCovered +
    //             "\nNumber of records        : " + galamseyEvents.size() +
    //             "\nYear Records Started     : " + yearStarted;
    // }

    public String toString() {
        return observatoryName;
    }
}