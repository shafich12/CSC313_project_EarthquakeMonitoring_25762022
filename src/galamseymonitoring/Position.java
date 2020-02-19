package galamseymonitoring;

public class Position{
    private double Longitude;
    private double Latitude;

    /**
     * Constructor for Position class
     * @param Longitude double: Contains longitude value of position
     * @param Latitude double: Contains latitude value of position
     */
    public Position(double Longitude,double Latitude){
        this.Longitude = Longitude;
        this.Latitude = Latitude;

    }

    /**
     *
     * @param Longitude double: Value for longitude of the position
     */
    public void setLongitude(double Longitude){
        this.Longitude = Longitude;
    }

    /**
     *
     * @param Latitude double: Value for latitude of the position
     */
    public void setLatitude(double Latitude){
        this.Latitude = Latitude;
    }

    /**
     *
     * @return value for longitude
     */
    public double getLongitude(){
       return Longitude;
    }

    /**
     *
     * @return value for latitude
     */
    public double getLatitude(){
       return Latitude;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String str = Longitude + ", "+Latitude;
        return str;
    }
}