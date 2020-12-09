

class City implements Comparable<City> {
    private String name, state;
    private int population;
    private double growth, latitude, longitude;

    City(String name, double growth, double latitude, double longitude, int population, String state) {
        this.name = name;
        this.growth = growth;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.state = state;
    }

    String getName() {
        return name;
    }

    double getGrowth() {
        return growth;
    }

    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }

    int getPopulation() {
        return population;
    }

    String getState() {
        return state;
    }

    public int compareTo(City c) {
        int stateCmp = c.state.compareTo(this.state);
        int cityCmp = c.name.compareTo(this.name);
        
        if (stateCmp ==  0) {
            if (cityCmp ==  0) {
                return 0;
            }
            return cityCmp;
        }
        return stateCmp;
    }

    @Override
    public String toString() {
        return "[" + state + "] [" + name + "] [" + population + "] [" + latitude + "] [" + longitude + "] [" + growth + "]";      
    }
}