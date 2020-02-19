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
 * Instance variable: observatories(type List<Observatory>)
 */
public class Monitoring{

    public static List<Observatory> observatories = new ArrayList<>();

    /**
     * Default constructor
     */
    public Monitoring(){

    }

    /**
     * Class for displaying all observatory information
     */
    public void showAllObservatoryInfo(){
        /**
         * for each loop
         */
        for (Observatory observatory:
             observatories) {
            System.out.println(observatory.viewDetails());
            System.out.println("\n");
        }
    }

    /**
     * Class "largestAverageObservatory()"
     * @return name of the largest observatory
     */
    public String largestAverageObservatory(){
        float max = 0;
        String name = "";

        for (Observatory observatory : observatories) {
            /**
             * if-statements nested in for each loop , for looping through all the observatories
             */
            if(observatory.getAverageColourValue() > max){
                max = observatory.getAverageColourValue();
                name = observatory.getObservatoryName();
            }
        }

        return name;
    }

    /**
     * Class largestAverageValue()
     * @return max average value
     */
    public float largestAverageValue(){
        float max = 0;

        /**
         * for each loop to compare average values to find max
         */
        for (Observatory observatory : observatories) {
            if(observatory.getAverageColourValue() > max){
                max = observatory.getAverageColourValue();
            }
        }

        return max;
    }

    /**
     * Class largestColourValue
     * @return largest colour value
     */
    public int largestColourValue(){
        int max = 0;

        /**
         * for each loop , nested if-statement for finding the highest colour value
         */
        for (Observatory observatory : observatories) {
            if(observatory.getHighestColourValue() > max){
                max = observatory.getHighestColourValue();
            }
        }

        return max;
    }

    /**
     *
     * @param value
     * @return all galamsey records grater than a specific value
     */
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