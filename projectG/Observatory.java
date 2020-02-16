/**
 *@author Kofi Boampong Benefo
 @author Jeffrey Kafui Adorkor 
 @author Yesu K. Apraku
 @author Shafic Hijazi
 Intermediate Computer Programing - Galamsey Project
 Observatory Class
 */

/**
 * Required packege imports
 */
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Observatory class
 * Instance variables: observatoryName
 *                     coutryName
 *                     areaCovered
 *                     galamseyEvents(which is of type List. It contains all the galamsey cases recorded)
 *                     yearStarted
 */
public class Observatory {
    private String observatoryName;
    private String countryName;
    private int areaCovered;
    private List<Galamsey> galamseyEvents;
    private int yearStarted;

    /**
     * Overloaded constructor
     * @param observatoryName
     * @param countryName
     * @param areaCovered
     * @param yearStarted
     */
    public Observatory(String observatoryName, String countryName, int areaCovered, int yearStarted){
        this.observatoryName = observatoryName;
        this.countryName = countryName;
        this.areaCovered = areaCovered;
        this.yearStarted = yearStarted;

        /**
         * Variable name for ArrayList
         */
        galamseyEvents = new ArrayList<>();
        /**
         * Add the observatory ceeated to the list of observatories 
         */
        Monitoring.observatories.add(this);
    }

/**
 * Mutator method for countryName
 * @param countryName
 */
    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }
/**
 * Mutator method for AreaCovered
 * @param areaCovered
 */r
    public void setAreaCovered(final int areaCovered) {
        this.areaCovered = areaCovered;
    }

    /**
     * Accessor method for ObservatoryName
     * @return
     */
    public String getObservatoryName() {
        return observatoryName;
    }

    /**
     * Mutator method for observatoryName
     * @param observatoryName
     */
    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    /**
     * Accessor method for  countryName 
     * @return
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Accessor  method for AreaCovered
     * @return
     */
    public int getAreaCovered() {
        return areaCovered;
    }

    /**
     *Accessor method for the GalamseyEvents list 
     */
    public List<Galamsey> getGalamseyEvents() {
        return galamseyEvents;
    }

    /**
     *mutator method for GalamseyEvents
     * @param galamseyEvents
     */
    public void setGalamseyEvents(List<Galamsey> galamseyEvents) {
        this.galamseyEvents = galamseyEvents;
    }

    /**
     * Accessor method for YearStarted
     * @return
     */
    public int getYearStarted() {
        return yearStarted;
    }

    /**
     * Mutator method for yearStarted
     * @param yearStarted
     */
    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    /**
     * Over loaded Constructor for createEvent
     * @param vegetationColour
     * @param colourValue
     * @param position
     * @param year
     */
    public void createEvent(Galamsey.colour vegetationColour, int colourValue, Position position, int year){
        Galamsey newEvent = new Galamsey(vegetationColour, colourValue, position, year);
        galamseyEvents.add(newEvent);
    }

    /**
     * Test method
     */
    public void viewEvents(){
        for (Galamsey galamsey : galamseyEvents) {
            System.out.println(galamsey.getColourValue());
        }
    }

    /**
     * Accessor method for the HighestColourValue 
     * @return
     */
    public int getHighestColourValue(){
        int max = 0;
        for (Galamsey galamsey : galamseyEvents) {
            if(galamsey.getColourValue() >= max){
                max = galamsey.getColourValue();
            }
        }
        return max;
    }

    /**
     * Accessor method for AverageColourValue
     * @return
     */
    public float getAverageColourValue(){
        float sum = 0;
        float count = 0;

        /**
         * For each loop for summing up and averaging Colour value
         */
        for (Galamsey galamsey : galamseyEvents) {
            sum = sum + galamsey.getColourValue();
            count++;
        }
        return sum/count;
    }

    /**
     * Accessor method for AllEvents
     * @param value
     * @return
     */
    public List<Galamsey> getAllEvents(int value){

        List<Galamsey> largerThan = new ArrayList<>();

        for(Galamsey galamsey: galamseyEvents){
            if(galamsey.getColourValue() > value){
                largerThan.add(galamsey);
            }
        }

        return largerThan;
    }

    /**
     * To String method 
     */
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