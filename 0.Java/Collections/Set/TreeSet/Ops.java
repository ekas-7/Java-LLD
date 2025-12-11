
import java.util.Set;
import java.util.TreeSet;

public class Ops {
    public static void main(String[] args) {
       Set<Integer> set = new TreeSet<>();

        set.add(8);
        set.add(10);
        set.add(19);
        set.add(21);

        System.out.println(set);

        set.remove(10);

        System.out.println(set);

        System.out.println(set.contains(21));

        System.out.println(set.size());
    }
}