package JavaBasic;
// only one CLASS named "public" in one '.java' file 
public class Function {
    public static void main(String[] args) {
        Point point = new Point(2);
        System.out.println(point.toString());
        System.out.println();

        // System.out.println(Point.value);
        // System.out.println(new Point());
    }
}
// outSide of the PUBLIC CLASS
class Point {
    // public static int value = 0;

    // public static int getValue() {
    //     return value;
    // }


    private int x = 0;
    private int y = 0;
    // Builder Func no need named RETURN TYPE
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(int x) {
        this.x = x;
        this.y = x;
    }
    public String toString() {
        return "(x:" + this.x + ", y:" + this.y + ")";
    }
}