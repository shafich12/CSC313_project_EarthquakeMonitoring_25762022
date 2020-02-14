import java.util.ArrayList;
import java.util.List;

public class Monitoring{

public static List<Observatory> observatories = new ArrayList<>();

public Monitoring(){

}

public Observatory largestAverage(){
    float max = 0;
    for (Observatory observatory : observatories) {
        if(observatory.getAverageColourValue() > max){
            max = observatory.getAverageColourValue();
        }
    }

    return max;
}
    
    
}