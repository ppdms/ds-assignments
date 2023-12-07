import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Influenza_k {
    public static void main(String[] args){
        /* 
        Read the file
        1. ID, 2. Name, 3. Population, 4. Influenza Cases
       
       Idea: 
       1. Go through the file file and save the number of written lines aka
       the number of objects we have to create                              *DONE
       2. Create an array of that size and save the objects inside of there *DONE
       3. Create a QuickSort based algorithm that sorts that array          *DONE
       4. Grab the k first/last elements of the list and display them       *DONE

       *CAUTION*: if the given k is greater than array.length then exit
       the program and display an appropriate message to the user
       
        */  
        
        // Go through the file to find the number of objects
        int size = 0;
        String filePath = "test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                size++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        City[] cities = new City[size];

        // Go through the file once more and add the data to the 'cities' array
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] splited = line.split("\\s+");
                //System.out.println(Arrays.toString(splited));
                City city = new City();
                city.setID(Integer.valueOf(splited[0]));
                city.setName(splited[1]);
                city.setPopulation(Integer.valueOf(splited[2]));
                city.setInfluenzaCases(Integer.valueOf(splited[3]));

                // Add the city to the list
                cities[i] = city;
                
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(Arrays.toString(cities));

        // Request k
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        if (k > size){
            System.out.println("The k you entered exceeds the numbers of cities provided.");
            return;
        }

        // Sort the cities array
        quickSort(cities, 0, size-1);

        //Display the k cities with the highest priority
        System.out.println("\nThe top "+k+" cities are:");
        for (int i=0; i < k; i++){
            System.out.println(cities[i].getName());
        }
        
    }

    // QuickSort algorithm

    private static void quickSort(City[] cits, int start, int end) {
        if (end <= start) return;

        int pivot = partition(cits, start, end);

        quickSort(cits, start, pivot-1);
        quickSort(cits, pivot+1, end);
    }

    private static int partition(City[] cits, int start, int end) {
        int i = start-1;
        for (int j = start; j<= end-1; j++){
            if (cits[j].compareTo(cits[end]) == -1){
                i++;
                City temp = cits[j];
                cits[j] = cits[i];
                cits[i] = temp;
            }
        }
        i++;
        City temp = cits[end];
        cits[end] = cits[i];
        cits[i] = temp;
        return i;
    }
}
