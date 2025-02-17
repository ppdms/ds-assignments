import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class DynamicInfluenza_k_withPQ {
	public static void main(String[] args) {

		int size = 0;

		if (args.length != 2) {
			System.out.println("Usage: java DynamicInfluenza_k <k> <filepath>");
			System.exit(1);
		}

		int k = 0;
		try {
			k = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid value for k. Please provide an integer.");
			System.exit(1);
		}

		String filePath = args[1];

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			while (reader.readLine() != null) {
				size++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (k > size) {
			System.out.println("The k you entered exceeds the numbers of cities provided.");
			return;
		}

		Comparator<City> comparator = new NegativeComparator();

		PQ cities = new PQ(2 * k, comparator);

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splited = line.split("\\s+");
				City city = new City();
				city.setID(Integer.valueOf(splited[0]));
				city.setName(splited[1]);
				city.setPopulation(Integer.valueOf(splited[2]));
				city.setInfluenzaCases(Integer.valueOf(splited[3]));

				if (cities.size() == k) {
					if (comparator.compare(cities.min(), city) < 0) {
						cities.getmin();
						cities.insert(city);
					}
				} else {
					cities.insert(city);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] leaderboard = new String[k];

		System.out.println("\nThe top k cities are:");
		for (int i = k - 1; i >= 0; i--) {
			leaderboard[i] = cities.getmin().getName();
		}
		for (int i = 0; i < k; i++) {
			System.out.println(leaderboard[i]);
		}

	}

}
