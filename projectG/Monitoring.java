import java.util.ArrayList;
import java.util.List;

public class Monitoring{

    public static List<Observatory> observatories = new ArrayList<>();

    public Monitoring(){

    }

    public String largestAverage(){
        float max = 0;
        String name = "";
        for (Observatory observatory : observatories) {
            if(observatory.getAverageColourValue() > max){
                max = observatory.getAverageColourValue();
                name = observatory.getObservatoryName();
            }
        }

        return name;
    }

    public int largestColourValue(){
        int max = 0;

        for (Observatory observatory : observatories) {
            if(observatory.getHighestColourValue() > max){
                max = observatory.getHighestColourValue();
            }
        }

        return max;
    }

    public List<Galamsey> galamseyCompare(int value){

        List<Galamsey> allGalamseys = new ArrayList<>();

        for (Observatory observatory : observatories) {
            for (Galamsey galamsey : observatory.getAllEvents(value)) {
                allGalamseys.add(galamsey);
            }
        }

        return allGalamseys;

    }
        
        
}