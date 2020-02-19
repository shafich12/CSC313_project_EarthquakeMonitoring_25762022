/**
 * @author Kofi Boampong Benefo-Bandoh
 * @author Jeffrey Kafui Adorkor
 * @author Yesu K. Apraku
 * @author Shafic Hijazi
 * Intermediate Compputer Programming
 * Galamsey class
 */

/**
 * Required packages to be imported
 */
import java.sql.SQLException;
import java.time.Year;

/**
 * Galamsey Class with instance variables: colour[type enum(green, yellow, brown)]
 *                                         position (type POsition)
 *                                         colourValue(type int)
 *                                         YearOfEvent(type int)
 *                                         observatory(type Observatory)
 */
public class Galamsey{
    @SuppressWarnings("unused")
	public enum colour{
		green,
		yellow, 
		brown; 
	}

    private Position position;
    private colour vegColour;
    private int colourValue;
    private int YearOfEvent;

    private Observatory observatory;

    /**
     * Galamsey() constructor
     */
    public Galamsey(){

    }

    /**
     * Overloaded constructor
     * @param vegColor
     * @param colourValue
     * @param position
     * @param yearofYear
     */
    public Galamsey(colour vegColor, int colourValue, Position position, int yearofYear){
        this.vegColour = vegColor;
        this.colourValue = colourValue;
        this.position = position;
        this.YearOfEvent = yearofYear;

    }

    /**
     * Mutator method for Position
     * @param position
     */
    public void setPosition(Position position){
        this.position = position;
    }

    /**
     * Mutator method for VegColor
     * @param vegColour
     */
    public void setVegColor(colour vegColour){
        this.vegColour = vegColour;
    }

    /**
     * Mutator method for colourValue
     * @param colourValue
     */
    public void setColourValue(int colourValue){
        this.colourValue = colourValue;
    }

    /**
     * Mutator method for yearOfEvent
     * @param yearOfEvent
     */
    public void setYear(int yearOfEvent){
        this.YearOfEvent = yearOfEvent;
    }

    /**
     * Mutator method for observatory
     * @param observatory
     */
    public void setObservatory(Observatory observatory){ this.observatory = observatory; }

    /**
     * Accessor method for Position
     * @return
     */
    public Position getPosition(){
        return position;
    }

    /**
     * Accessor method VegColor
     * @return
     */
    public colour getVegColor(){
        return vegColour;
    }

    /**
     * Accessor method for Observatory
     * @return
     */
    public Observatory getObservatory(){return observatory;}

    /**
     * Accessor method for ColourValue
     * @return
     */
    public int getColourValue(){
        return colourValue;
    }

    /**
     * Accessor method for YearOfEvent
     * @return
     */
    public int getYearOfEevent(){
        return YearOfEvent;
    }

    /**
     * Error handling for Database
     * @throws SQLException
     */
    public void addToDB() throws SQLException {
        System.out.println("I might be working");
        MonitoringIO.db.insertGalamsey(this);
    }

    @Override
    /**
     * To string method
     */
    public String toString() {
        String str = "Position: " + position.toString()
                        + " Colour Value: " + this.getColourValue()
                        + " Year of Event: " + this.getYearOfEevent();

        return str;
    }
}

