import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("Apple", 100);
        map.put("Banana", 50);
        map.put("Cherry", 200);

        System.out.println("Value of Banana: " + map.get("Banana"));

        map.remove("Cherry");

        System.out.println("Contains key Apple? " + map.containsKey("Apple"));
        System.out.println("Contains value 200? " + map.containsValue(200));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        System.out.println("\nIterating using forEach():");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
