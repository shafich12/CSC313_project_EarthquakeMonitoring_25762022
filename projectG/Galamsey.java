import java.time.Year;

public class Galamsey{
    public static enum colorValue{ONE,TWO,THREE};


    private Position position;
    private String vegColor;
    private colorValue cValue;
    private Year YearOfEvent;

    public Galamsey(){

    }
    
    public Galamsey(String vegColor, colorValue cValue, Position position, Year yearofYear){
        this.vegColor = vegColor;
        this.cValue = cValue;
        this.position = position;
        this.YearOfEvent = yearofYear;

    }
    public void setPosition(Position position){
        this.position = position;
    }

    public void setVegColor(String vegColor){
        this.vegColor = vegColor;
    }

    public void setCvalue(colorValue cValue){
        this.cValue = cValue;
    }

    public void setYear(Year yearOfEvent){
        this.YearOfEvent = yearOfEvent;
    }
    
    public Position getPosition(){
        return Position;
    }

    public String getVegColor(){
        return vegColor;
    }

    public colorValue getCvalue(){
        return cValue;
    }

    public Year getYearOfEevent(){
        return YearOfEvent;
    }
}

