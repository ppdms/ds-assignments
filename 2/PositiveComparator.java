import java.text.DecimalFormat;
import java.util.Comparator;

public class PositiveComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        // If 0 is returned then o1.City will have greater priority than o2

        // Create a DecimalFormat object with a pattern for two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        // Format the float value using the DecimalFormat
        String o1Val = decimalFormat.format(((float) o1.getInfluenzaCases() / o1.getPopulation()) * 50000);
        String o2Val = decimalFormat.format(((float) o2.getInfluenzaCases() / o2.getPopulation()) * 50000);
        // Check priority based on cases per 50000
        if (Float.valueOf(o1Val) < Float.valueOf(o2Val))
            return -1;
        else if (Float.valueOf(o1Val) > Float.valueOf(o2Val))
            return 1;

        // Check priority based on name
        int ans = o1.getName().compareTo(o2.getName());
        if (ans < 0)
            return -1;
        else if (ans > 0)
            return 1;

        // Check priority based on ID
        if (o1.getID() < o2.getID())
            return -1;
        return 1;
    }
}
