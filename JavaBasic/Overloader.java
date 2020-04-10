package JavaBasic;

// MUST diff params LIST(num or classes)
// https://www.runoob.com/wp-content/uploads/2013/12/overloading-vs-overriding.png
// https://www.runoob.com/wp-content/uploads/2013/12/overloading-vs-overriding.png
public class Overloader {
    public static void main(String[] args) {
        Overloader overloader = new Overloader();
        System.out.println(overloader.test(5));
    }

    public int test() {
        return 1;
    }
    
    public int test(int val) {
        return val;
    }
}