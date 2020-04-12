package StackQueueHash;

import java.util.NoSuchElementException;

public class MyQueue {

    private ListNode head;
    private ListNode tail;

    public void offer(int val) {
        if(tail == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        
    }

    public int poll() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int res = head.val;
        // System.out.println("head before poll 1st: " + head.val);
        head = head.next;
        // System.out.println("head after poll 1st:" + head.val);
        if(head == null) {
            tail = null;
        }
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

// package StackQueue;

// import java.util.NoSuchElementException;

// public class MyQueue {
//     private ListNode head;
//     private ListNode tail;

//     public void offer(int val) {
//         if(tail == null) {
//             head = tail = new ListNode(val); // none in queue, head = tail
//         }
//         tail.next = new ListNode(val);
//         tail = tail.next;
//     }

//     public int pull() {
//         if(isEmpty()) {
//             throw new NoSuchElementException();
//         }
//         int res = head.val;
//         head = head.next;
//         // if none in queue, head.next = null
//         if(head == null) {
//             tail = null;
//         }
//         return res;
//     }

//     public int peek() {
//         if(isEmpty()) {
//             throw new NoSuchElementException();
//         }
//         return head.val;
//     }

//     public boolean isEmpty() {
//         return head == null;
//     }

//     public class ListNode {
//         int val;
//         ListNode next;

//         ListNode(int val) {
//             this.val = val;
//         }
//     }
// }