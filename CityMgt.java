import java.util.*;
import java.io.*;

public class CityMgt {
    ArrayList<City> cities = new ArrayList<City>();

    ArrayList<City> get()
    {
        return cities;
    }

    void read()
    {
        cities.forEach((city) -> {
            System.out.println(city);
        });
    }

    void set(ArrayList<City> cities)
    {
        this.cities = cities;
    }

    /* Turn file to map */
    void add(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; // A variable to store line from file

            // Loop to go through the entire file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Parse line to array
                // Santize input of object

                //using RegEx to split the line being read into the different elements of the object we are creating 
                if (line.matches("([\\'\\.\\w-\\(\\)\\(\\) ]+),(\\-?(\\d+)?\\.?\\d+),(\\-?(\\d+)?\\.?\\d+),(\\-?(\\d+)?\\.?\\d+),\\d+,[\\'\\.\\w-\\(\\)\\(\\) ]+")) {
                    // Parse array to settlement object
                    City city = new City(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5]);
                    cities.add(city);

                } else {
                    //will display if the line is unable to be read in due to it not being in the correct format
                    System.out.println("Warning: \"" + line + "\" is not in the correct format, or courrpted.");
                }
            }
            br.close();
        } catch (Exception e) // Catch error
        {
            System.out.println("Warning: " + e.toString() + "."); // Print error
        }
    }

}
