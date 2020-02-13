import java.time.Year;

public class Galamsey{
    @SuppressWarnings("unused")
	public enum colour{
		green,
		yellow, 
		brown 
	}

    private Position position;
    private colour vegColour;
    private int colourValue;
    private int YearOfEvent;

    public Galamsey(){

    }
    
    public Galamsey(colour vegColor, int colourValue, Position position, int yearofYear){
        this.vegColour = vegColor;
        this.colourValue = colourValue;
        this.position = position;
        this.YearOfEvent = yearofYear;

    }
    public void setPosition(Position position){
        this.position = position;
    }

    public void setVegColor(colour vegColour){
        this.vegColour = vegColour;
    }

    public void setColourValue(int colourValue){
        this.colourValue = colourValue;
    }

    public void setYear(int yearOfEvent){
        this.YearOfEvent = yearOfEvent;
    }
    
    public Position getPosition(){
        return position;
    }

    public colour getVegColor(){
        return vegColour;
    }

    public int getColourValue(){
        return colourValue
        ;
    }

    public int getYearOfEevent(){
        return YearOfEvent;
    }
}

