package StackQueueHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// add more info
// add more info agai

//import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(4);
        // stack.push(3);
        // stack.push(2);
        // stack.push(1);

        // while(!stack.isEmpty()) {
        //     System.out.println(stack.peek());
        //     stack.pop();
        // }
        MyStack mystack = new MyStack();
        mystack.push(2);
        mystack.push(3);
        while(!mystack.isEmpty()) {
            System.out.println(mystack.pop());
        }

        MyQueue myqueue = new MyQueue();
        myqueue.offer(10);
        myqueue.offer(2);
        myqueue.offer(3);
        while(!myqueue.isEmpty()) {
            System.out.print(myqueue.peek() + " ");
            myqueue.poll();
        }

        Set<Integer> set = new HashSet<>(); // TreeSet log(n) HashSet O(1)
        set.add(10);
        set.add(20);
        set.add(-3);
        set.add(8);

        System.out.println(set.contains(10));
        set.remove(8);
        System.out.println(set.contains(8));

        System.out.println(set.size());
        for(int num: set) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        //                 put             get
        // List            O(n)            O(n)
        // Balanced BST  O(log n)        O(log n)
        // Hash Table      O(1)            O(1)
        
        Map<String, String> map = new HashMap<>();
        map.put("David", "SJTU");
        map.put("Cindy", "MIT");
        map.put("Tom", "Berkeley");
        map.put("Alex", "Stanford");

        System.out.println(map.get("David"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        for(String key: map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}