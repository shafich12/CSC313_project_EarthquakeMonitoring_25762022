public class Position{
    private double Longitude;
    private double Latitude;

    public Position(double Longitude,double Latitude){
        this.Longitude = Longitude;
        this.Latitude = Latitude;

    }

    public void setLongitude(double Longitude){
        this.Longitude = Longitude;
    }

    public void setLatitude(double Latitude){
        this.Latitude = Latitude;
    }

    public double getLongitude(){
       return Longitude;
    }

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