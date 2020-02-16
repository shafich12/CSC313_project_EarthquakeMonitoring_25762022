import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MonitoringIO{

    public static Observatory currentObservatory;
    public static Monitoring monitor = new Monitoring();
    public static Database db = new Database();

    public static void main(String[] args) {
        loadFromDB();
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
            statsController();
        }
        else{
            System.exit(0);
        }
    }

    public static void statsController(){

        System.out.println("1. View all observatories");
        System.out.println("2. General Statistics");
        System.out.println("3. Colour value greater than give number");
        System.out.println("0. Return");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1){
            showAllObservatories(monitor);
        }
        else if(choice == 2){
            generalStats(monitor);
        }
        else if(choice == 3){
            largerThanValue(monitor);
        }
        else{
            menuController();
        }
    }

    public static void showAllObservatories(Monitoring monitor){
        monitor.showAllObservatoryInfo();
        menuController();
    }

    public static void generalStats(Monitoring monitor){
        System.out.println("Largest average colour value: " + monitor.largestAverageValue()
                        + " Recorded from: " + monitor.largestAverageObservatory());
        System.out.println("Largest galamsey value recorded: " + monitor.largestColourValue());

        menuController();
    }

    public static void largerThanValue(Monitoring monitor){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter comparing colour value: ");
        int value = input.nextInt();

        for(Galamsey galamsey: monitor.galamseyCompare(value)){
            System.out.println(galamsey);
            System.out.println("\n");
        }
        
        menuController();
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
        try {
            observatory.addtoDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("Observatory created successfully");

        menuController();
    }

    public static void enterGalamseyData(){

        Scanner input = new Scanner(System.in);
        int i = 0;

        if(Monitoring.observatories.size() == 0){
            System.out.println("No observatories. Please add an observatory before recording galamsey data");
            menuController();
        }

        System.out.println("Choose an observatory");
        for (Observatory e : Monitoring.observatories) {
            System.out.println(i + ". " + e.getObservatoryName());
            i++;
        }
            
        int decision = input.nextInt();
        currentObservatory = Monitoring.observatories.get(decision);

        input.nextLine();
        System.out.println("Enter galamsey details for " + currentObservatory.getObservatoryName());

        System.out.println("Provide vegetation colour (Green, Yellow, Brown)");
        String vegetationColour = input.nextLine();
        Galamsey.colour colour = Galamsey.colour.valueOf(vegetationColour.toLowerCase());

        System.out.println("Enter colour value (Green (1), Yellow(2), Brown(3))");
        int colourValue = input.nextInt();

        System.out.println("Enter latitude");
        double latitude = input.nextDouble();

        System.out.println("Enter longitude");
        double longitude = input.nextDouble();

        System.out.println("Enter year");
        int year = input.nextInt();

        currentObservatory.createEvent(colour, colourValue, new Position(latitude, longitude), year);
        menuController();

    }

    public static void loadFromDB(){

        try {
            MonitoringIO.db.initialLoad();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}