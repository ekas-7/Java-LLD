import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeap {
  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue<>();

    pq.offer(18);
    pq.offer(16);
    pq.offer(1);
    pq.offer(7);

    System.out.println(pq.peek());

    pq.poll();

    System.out.println(pq.peek());
  }  
}
