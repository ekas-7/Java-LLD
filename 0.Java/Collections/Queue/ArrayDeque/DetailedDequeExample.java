import java.util.ArrayDeque;
import java.util.Deque;

public class DetailedDequeExample {

    public static void main(String[] args) {

        /*
         * Deque stands for "Double Ended Queue".
         * It allows insertion and deletion from BOTH front and rear.
         * 
         * Here we use ArrayDeque (most common Deque implementation).
         */
        Deque<Integer> dq = new ArrayDeque<>();

        /*
         * --------------------------
         * INSERTION OPERATIONS
         * --------------------------
         * offerLast()  -> adds element at the REAR (queue behavior)
         * offerFirst() -> adds element at the FRONT (stack-like or custom behavior)
         */

        dq.offerLast(18);  // inserted at rear
        dq.offerLast(16);  // inserted at rear
        dq.offerLast(1);   // inserted at rear
        dq.offerLast(7);   // inserted at rear

        /*
         * Current Deque order (front → rear):
         * [18, 16, 1, 7]
         */


        /*
         * --------------------------
         * PEEK OPERATIONS
         * --------------------------
         * peekFirst() -> see the FRONT element without removing
         * peekLast()  -> see the REAR element without removing
         */

        System.out.println("Front element (peekFirst): " + dq.peekFirst());
        System.out.println("Rear element  (peekLast): " + dq.peekLast());

        /*
         * --------------------------
         * REMOVAL OPERATIONS
         * --------------------------
         * pollFirst() -> removes and returns FRONT element
         * pollLast()  -> removes and returns REAR element
         */

        System.out.println("\nRemoving front element using pollFirst(): " + dq.pollFirst());

        /*
         * After removal, Deque becomes:
         * [16, 1, 7]
         */

        System.out.println("New front element: " + dq.peekFirst());


        /*
         * --------------------------
         * PRINT ENTIRE DEQUE
         * --------------------------
         */
        System.out.println("\nFinal Deque: " + dq);
    }
}
