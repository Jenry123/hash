// HashTable.java
import java.util.ArrayList;

public class HashTable {
    private ArrayList<LinkedList> multiplicationTable;
    private ArrayList<LinkedList> divisionTable;
    private int size;

    public HashTable() {
        this.size = 1000; // Choose a suitable size for the hash table
        this.multiplicationTable = new ArrayList<>(size);
        this.divisionTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            multiplicationTable.add(new LinkedList());
            divisionTable.add(new LinkedList());
        }
    }

    private int hashMultiplication(String key) {
        int hash = Math.abs(key.hashCode()); // Asegurar que el hash sea positivo
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) (size * (hash * A % 1));
    }

    private int hashDivision(String key) {
        int hash = Math.abs(key.hashCode()); // Asegurar que el hash sea positivo
        return hash % size;
    }

    public void insertMultiplication(String key, String[] data) {
        int index = hashMultiplication(key);
        multiplicationTable.get(index).insert(key, data);
    }

    public void insertDivision(String key, String[] data) {
        int index = hashDivision(key);
        divisionTable.get(index).insert(key, data);
    }

    public String[] searchMultiplication(String key) {
        int index = hashMultiplication(key);
        return multiplicationTable.get(index).search(key);
    }

    public String[] searchDivision(String key) {
        int index = hashDivision(key);
        return divisionTable.get(index).search(key);
    }
}
