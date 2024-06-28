// Main.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        int id = 1;

        HashTable hashTable = new HashTable();

        try {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));

            // Leer y descartar la primera línea (encabezado)
            br.readLine();

            long startTime, endTime;

            // Medir el tiempo de inserción para la función de multiplicación
            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(splitBy); // use comma as separator
                String key = business[0];
                hashTable.insertMultiplication(key, business);
                id++;
            }
            endTime = System.nanoTime();
            long insertionTimeMultiplication = endTime - startTime;

            // Resetear el BufferedReader para leer el archivo de nuevo
            br.close();
            br = new BufferedReader(new FileReader("bussines.csv"));
            br.readLine(); // Descartar la primera línea de nuevo

            id = 1;
            // Medir el tiempo de inserción para la función de división
            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(splitBy); // use comma as separator
                String key = business[0];
                hashTable.insertDivision(key, business);
                id++;
            }
            endTime = System.nanoTime();
            long insertionTimeDivision = endTime - startTime;

            System.out.println("Insertion time (Multiplication): " + insertionTimeMultiplication + " ns");
            System.out.println("Insertion time (Division): " + insertionTimeDivision + " ns");

        } catch (IOException e) {
            e.printStackTrace();
        }


        String searchKey = "tUFrWirKiKi_TAnsVWINQQ"; // Example search key

        // Medir el tiempo de búsqueda para la función de multiplicación
        long startTime = System.nanoTime();
        String[] resultMultiplication = hashTable.searchMultiplication(searchKey);
        long endTime = System.nanoTime();
        long searchTimeMultiplication = endTime - startTime;

        // Medir el tiempo de búsqueda para la función de división
        startTime = System.nanoTime();
        String[] resultDivision = hashTable.searchDivision(searchKey);
        endTime = System.nanoTime();
        long searchTimeDivision = endTime - startTime;

        if (resultMultiplication != null) {
            System.out.println("Found using multiplication: " + String.join(", ", resultMultiplication));
        } else {
            System.out.println("Not found using multiplication");
        }

        if (resultDivision != null) {
            System.out.println("Found using division: " + String.join(", ", resultDivision));
        } else {
            System.out.println("Not found using division");
        }

        System.out.println("Search time (Multiplication): " + searchTimeMultiplication + " ns");
        System.out.println("Search time (Division): " + searchTimeDivision + " ns");
    }
}
