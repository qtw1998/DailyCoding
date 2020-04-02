package StackQueue;
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
    }
}