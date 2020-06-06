package LinkedList;
/*           arrylist           LinkedList
add(0, v)      O(1)                O(1)   
add(n, v)      O(1)                O(n)
add            O(1)                O(n)
get            O(1)                O(n)
set            O(1)                O(n)
*/
class MyLinkedList {
    private ListNode dummy = new ListNode(-1); // private ListNode head;

    public void add(int location, int val) {
        // if (location > 0) {
        //     ListNode pre = head;
        //     for (int i = 0; i < location - 1; i++) {
        //         pre = pre.next;
        //     }
        //     ListNode newNode = new ListNode(val);
        //     newNode.next = pre.next;
        //     pre.next = newNode;
        // } else {
        //     ListNode newNode = new ListNode(val);
        //     newNode.next = head;
        //     head = newNode;
        // }
        ListNode cur = dummy;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        pre.next = newNode;
    }
    
    public int get(int location) {
        ListNode cur = dummy.next; //ListNode cur = head;
        for (int i = 0; i < location; ++i) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void set(int location, int val) {
        ListNode cur = dummy.next; //ListNode cur = head;
        for (int i = 0; i < location; ++i) {
            cur = cur.next;
        }
        cur.val = val;
    }

    public int remove(int location) {
    //     ListNode res = null;
    //     if (location > 0) {
    //         ListNode pre = head;
    //         for (int i = 0; i < location; ++i) {
    //             pre = pre.next;
    //         }
    //         res = pre.next;
    //         pre.next = pre.next.next;
    //     }else {
    //         res = head;
    //         head = head.next;
    //     }
    //     return res.val;
    // }
    ListNode res = null;
    ListNode pre = dummy;
    for(int i = 0; i < location; ++i) {
        pre = pre.next;
    }
    res = pre.next;
    pre.next = pre.next.next;
    
    return res.val;
    }
}