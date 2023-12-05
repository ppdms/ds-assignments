import java.text.DecimalFormat;

public class City implements CityInterface, Comparable<City>{
    private int id;
    private String name;
    private int population;
    private int influenzaCases;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public int getPopulation() {
        return population;
    }

    @Override
    public int getInfluenzaCases() {
        return influenzaCases;
    }

    @Override
    public void setID(int ID) {
        this.id = ID;
    }

    @Override
    public void setName(String name) {
        this.name = name;}

    @Override
    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public void setInfluenzaCases(int InfluenzaCases) {
        this.influenzaCases = InfluenzaCases;    
    }

    @Override
    public int compareTo(City other){
        // If 0 is returned then this.City will have greater priority than other

        // Create a DecimalFormat object with a pattern for two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        // Format the float value using the DecimalFormat
        String thisVal = decimalFormat.format(((float)this.influenzaCases / this.population)*50000);
        String otherVal = decimalFormat.format(((float)other.getInfluenzaCases()/other.getPopulation())*50000);
        // Check priority based on cases per 50000
        if (Float.valueOf(thisVal) < Float.valueOf(otherVal)) return 0;
        else if (Float.valueOf(thisVal) > Float.valueOf(otherVal)) return 1;

        // Check priority based on name
        int ans = this.name.compareTo(other.getName());
        if (ans < 0) return 0;
        else if (ans > 0) return 1;

        // Check priority based on ID
        if (this.id < other.getID()) return 0;
        return 1;
    }
    
}
