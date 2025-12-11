
import java.util.LinkedHashSet;

public class Ops {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

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