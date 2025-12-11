import java.util.*;

public class HashMapDemo{
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // Add elements
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        // Get value
        System.out.println("Value for key B: " + map.get("B"));

        // Remove key
        map.remove("C");

        // Check presence
        System.out.println("Contains key A? " + map.containsKey("A"));
        System.out.println("Contains value 30? " + map.containsValue(30));

        // KeySet, Values, EntrySet
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        // Iteration - method 1
        System.out.println("\nUsing entrySet():");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        // Iteration - method 2
        System.out.println("\nUsing forEach():");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
