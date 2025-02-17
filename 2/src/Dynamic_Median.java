import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


public class Dynamic_Median {
	public static void main(String[] args) {

		if (args.length != 1) {
            System.out.println("Usage: java DynamicMedian <filepath>");
            System.exit(1);
        }

        String filePath = args[0];

		PQ lo = new PQ(500, new NegativeComparator());
		PQ hi = new PQ(500);

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splited = line.split("\\s+");
				City city = new City();
				city.setID(Integer.valueOf(splited[0]));
				city.setName(splited[1]);
				city.setPopulation(Integer.valueOf(splited[2]));
				city.setInfluenzaCases(Integer.valueOf(splited[3]));

				if (lo.size() == 0 && hi.size() == 0) {
					lo.insert(city);
					continue;
				}
				if (lo.size() == 1 && hi.size() == 0) {
					if (lo.min().compareTo(city) > 0) {
						hi.insert(lo.getmin());
						lo.insert(city);
						continue;
					} else {
						hi.insert(city);
						continue;
					}
				}

				if (lo.min().compareTo(city) > 0) {
					lo.insert(city);
				} else {
					hi.insert(city);
				}

				if ((hi.size() + lo.size()) % 2 == 0) {
					if (lo.size() == hi.size() + 2) {
						hi.insert(lo.getmin());
					}
				} else {
					if (lo.size() < hi.size()) {
						lo.insert(hi.getmin());
					}

				}

				if ((hi.size() + lo.size()) % 5 == 0) {
					DecimalFormat decimalFormat = new DecimalFormat("#.##");
        			String val = decimalFormat.format(((float) lo.min().getInfluenzaCases() / lo.min().getPopulation()) * 50000);
					System.out.println(val);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
