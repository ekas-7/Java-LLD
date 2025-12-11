import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ops {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        // Insert 50 at index 1
        list.add(1, 50);

        System.out.println(list);


        List<Integer> newList = new ArrayList<>();
        newList.add(43);
        newList.add(67);

        list.addAll(newList);

        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(Integer.valueOf(43));
        System.out.println(list);

        // list.clear();

        list.set(1,7);
        System.out.println(list);

        System.out.println(list.contains(7));
        System.out.println(list.contains(100));


        for(int i=0;i<list.size();i++){
            System.out.println("The element is "+ list.get(i));
        }

        for(Integer elemet: list){
            System.out.println("for each "+ elemet);
        }

        Iterator<Integer>it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
