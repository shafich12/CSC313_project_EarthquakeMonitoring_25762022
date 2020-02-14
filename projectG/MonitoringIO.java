import java.util.List;
import java.util.Scanner;

public class MonitoringIO{

    public static Observatory currentObservatory = null;

    public static void main(String[] args) {

        menuController();
    }

    public static void menuController() {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Enter observatory data");
        System.out.println("2. Enter 'galamsey' data");
        System.out.println("3. Show statistics");
        System.out.println("0. Exit");

        //String str = input.nextLine();
        int choice = input.nextInt();

        if(choice == 1){
            enterObservatoryData();
        }
        else if(choice == 2){
            enterGalamseyData();
        }
        else if(choice == 3){
            stats();
        }
        else{
            System.exit(0);
        }
    }

    public static void stats(){
        System.out.println("1. General Statistics");
        System.out.println("2. Colour value greater than give number");
        System.out.println("0. Return");
    }

    public static void enterObservatoryData() {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter Observatory name");
        String name = input.nextLine();

        System.out.println("Enter country location");
        String country = input.nextLine();

        System.out.println("Enter area covered(sq. km)");
        int area = input.nextInt();

        System.out.println("Enter year observations started");
        int year = input.nextInt();

        Observatory observatory = new Observatory(name, country, area, year);

        menuController();
    }

    public static void enterGalamseyData(){

        Scanner input = new Scanner(System.in);
        List<Observatory> observatories = Monitoring.observatories;
        int i = 1;

        if(currentObservatory.equals(null)){
            System.out.println("Choose an observatory");
            for (Observatory e : observatories) {
                System.out.println(i + ". " + e.getObservatoryName());
                i++;
            }
            String decision = input.nextLine();
            currentObservatory = observatories.get(Integer.parseInt(decision));
        }

        System.out.println("Enter galamsey details for " + currentObservatory.getObservatoryName());

        System.out.println("Enter vegetation colour");
        Galamsey.colour colour = Galamsey.colour.valueOf(input.nextLine().toLowerCase());

        System.out.println("Enter colour value");
        int colourValue = input.nextInt();

        System.out.println("Enter latitude");
        double latitude = input.nextDouble();

        System.out.println("Enter longitude");
        double longitude = input.nextDouble();

        System.out.println("Enter year");
        int year = input.nextInt();

        Galamsey galamsey = new Galamsey(colour, colourValue, new Position(latitude, longitude), year);

    }


}