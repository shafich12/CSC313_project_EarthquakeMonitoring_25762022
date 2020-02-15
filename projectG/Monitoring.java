import java.util.ArrayList;
import java.util.List;

public class Monitoring{

    public static List<Observatory> observatories = new ArrayList<>();

    public Monitoring(){

    }

    public void showAllObservatoryInfo(){
        for (Observatory observatory:
             observatories) {
            System.out.println(observatory);
            System.out.println("\n");
        }
    }

    public String largestAverageObservatory(){
        float max = 0;
        String name = "";

        if(observatories.size() == 0){
            return "No observatories have been created.";
        }

        for (Observatory observatory : observatories) {
            if(observatory.getAverageColourValue() > max){
                max = observatory.getAverageColourValue();
                name = observatory.getObservatoryName();
            }
        }

        return name;
    }

    public float largestAverageValue(){
        float max = 0;


        for (Observatory observatory : observatories) {
            if(observatory.getAverageColourValue() > max){
                max = observatory.getAverageColourValue();
            }
        }

        return max;
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