package sort;

import java.util.*;

public class SortInJava {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(-1);
        arrayList.add(9);
        arrayList.add(3);

        for(int num: arrayList) {
            System.out.print(num + " ");
        }
        System.out.println();

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num: arrayList) {
            System.out.print(num + " ");
        }
        System.out.println();

        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("Jack", 100));
        stuList.add(new Student("Cindy", 99));
        stuList.add(new Student("David", 95));
        Comparator<Student> comparator1 = new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                return stu1.score - stu2.score;
            }
        };
        for(Student stu: stuList) {
            System.out.println(stu.name + ":" + stu.score);
        }
    }
}

class Student{
    int score;
    String name;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}