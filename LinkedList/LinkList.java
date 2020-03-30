public class LinkList {

    public static void main(final String[] args) {
        runLinedList();
    }

    public static void runLinedList() {
        System.out.println("LinkedList");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        ListNode cur = node1;
        while(cur != null) {
            System.out.println(cur.val + "->");
            cur = cur.next;
        }
        traverseLinkedList(node1);
    }
    public static void traverseLinkedList(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(final int val) {
        this.val = val;
        next = null;
    }
}