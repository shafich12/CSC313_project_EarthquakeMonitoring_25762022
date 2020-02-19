/**
 * @author Kofi Boampong Benefo-Bandoh
 * @author Jeffrey Kafui Adorkor
 * @author Yesu K. Apraku
 * @author Shafic Hijazi
 * Intermediate Computer Programming
 * Monitoring class
 */

/**
 * Required packages to be imported
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Monitoring Class
 * Instance variable: observatoriew
 */
public class Monitoring{

    public static List<Observatory> observatories = new ArrayList<>();

    public Monitoring(){

    }

    public void showAllObservatoryInfo(){
        for (Observatory observatory:
             observatories) {
            System.out.println(observatory.viewDetails());
            System.out.println("\n");
        }
    }

    public String largestAverageObservatory(){
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