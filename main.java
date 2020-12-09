import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Search search = new Search();
        Sort sort = new Sort();
        CityMgt cityMgt = new CityMgt();
        cityMgt.add("GPSdata.txt");

        Scanner sc = new Scanner(System.in);

        cityMgt.get().forEach((c) -> {
            System.out.println(c);
        });

        System.out.println("=================================================");
        System.out.println("LINEAR SEARCH FOR CITY");
        System.out.println("=================================================");

        System.out.println("Please enter the name of the city you wish to search for (THIS MUST MACH NAME EXACTLY, INCLUdING CAPITAL AT THE START)");
        String inputS = sc.nextLine();
        System.out.println();
        System.out.println();

        search.linear(cityMgt.get(), inputS).forEach(c-> {
                System.out.println("State: " + c.getState());
                System.out.println("City: " + c.getName());
                System.out.println("Population: " + c.getPopulation());
                System.out.println("Latitude: " + c.getLatitude());
                System.out.println("Longitude: " + c.getLongitude());
                System.out.println("Growth: " + c.getGrowth());
        });

        System.out.println();
        System.out.println();
        System.out.println("=================================================");
        System.out.println("BINARY SEARCH FOR POPULATION");
        System.out.println("=================================================");

        cityMgt.set(sort.bubbleSort(cityMgt.get()));
        System.out.println("Data has been sorted");
        System.out.println();
        System.out.println("Please enter the population ammount you wich to search for");
        int inputI = sc.nextInt();

        search.binary(cityMgt.get(), inputI).forEach(c-> {
            System.out.println("State: " + c.getState());
            System.out.println("City: " + c.getName());
            System.out.println("Population: " + c.getPopulation());
            System.out.println("Latitude: " + c.getLatitude());
            System.out.println("Longitude: " + c.getLongitude());
            System.out.println("Growth: " + c.getGrowth());
        });



        sc.close();


        

        
        
    }
}
