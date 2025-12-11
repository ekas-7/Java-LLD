import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Mango", 60);
        map.put("Apple", 20);
        map.put("Banana", 40);

        System.out.println("Value of Apple: " + map.get("Apple"));

        map.remove("Banana");

        System.out.println("Contains key Mango? " + map.containsKey("Mango"));
        System.out.println("Contains value 40? " + map.containsValue(40));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        // TreeMap-specific
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        System.out.println("\nIterating using forEach():");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
