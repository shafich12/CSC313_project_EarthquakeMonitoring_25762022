import java.util.ArrayList;
import java.time.Year;

public class Observatory{
    
    private String ObserveName;
    private String CountryOrigin;
    private Year galamseyStart;
    private double areaCovered;
    private String events;
    private String Location;


    public Observatory(){}

    public Observatory(String ObserveName, String CountryOrigin, Year galamseyStart, Double areaCovered, String events, String Location){
        this.ObserveName = ObserveName;
        this.CountryOrigin =CountryOrigin;
        this.galamseyStart = galamseyStart;
        this.areaCovered = areaCovered;
        this.events = events;
        this.Location = Location;
    }

    public String getObserveName() {
        return ObserveName;
    }

    public void setObserveName(String observeName) {
        ObserveName = observeName;
    }

    public String getCountryOrigin() {
        return CountryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        CountryOrigin = countryOrigin;
    }

    public Year getGalamseyStart() {
        return galamseyStart;
    }

    public void setGalamseyStart(Year galamseyStart) {
        this.galamseyStart = galamseyStart;
    }

    public double getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(double areaCovered) {
        this.areaCovered = areaCovered;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    
		
	}

    

