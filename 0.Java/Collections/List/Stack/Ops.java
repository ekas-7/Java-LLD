package Stack;

import java.util.Stack;

public class Ops {
    public static void main(String[] args) {
        Stack<String>animals = new Stack<>();

        animals.push("bear");
        animals.push("lion");
        animals.push("horse");

        System.out.println("Animals + "+ animals);

        System.out.println(animals.peek());

        animals.pop();

        System.out.println("Animals + "+ animals);

        System.out.println(animals.peek());
        
    }

    

}
