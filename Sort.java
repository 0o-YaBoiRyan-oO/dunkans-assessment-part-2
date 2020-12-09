import java.util.ArrayList;

public class Sort {
    
    ArrayList<City> bubbleSort(ArrayList<City> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<City> sorted = (ArrayList<City>)list.clone();

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).getPopulation() > sorted.get(j + 1).getPopulation()) {
                    City temp = sorted.get(j);
                    sorted.set(j,sorted.get(j+1));
                    sorted.set(j+1, temp);
                }
            }
        }

        return sorted;
    }
}
