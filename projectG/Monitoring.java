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
        
        
}