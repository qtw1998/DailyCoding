package StackQueueHash;

import java.util.NoSuchElementException;

public class MyStack {
    private ListNode head = null;

    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }
    
    public int pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int res = head.val;
        head = head.next;
        return res;
    }

    public int peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}