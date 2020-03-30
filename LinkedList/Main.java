package LinkedList;

class Main {
    public static void main(String[] args) {
        MyLinkedList mylinklist = new MyLinkedList();
        mylinklist.add(0, 1);
        mylinklist.add(1, 2);
        mylinklist.add(2, 3);
        mylinklist.add(3, 4);

        for (int i = 0; i < 4; i++) {
            System.out.print(mylinklist.get(i) + " ");
        }
        System.out.println();

        mylinklist.set(2, 5);
        for (int i = 0; i < 4; i++) {
            System.out.print(mylinklist.get(i) + " ");
        }
        System.out.println();

        mylinklist.add(4, 6);
        // System.out.println(mylinklist.remove(2));
        for (int i = 0; i < 5; i++) {
            System.out.print(mylinklist.get(i) + " ");
        }
        System.out.println();

        mylinklist.add(4, 7);

    }
}