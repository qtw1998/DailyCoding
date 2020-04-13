package JavaBasic;

public class Static {
    public static void main(String[] args) {
        PointStatic ps = new PointStatic();
        System.out.println(ps.getValue());
    }
}

class PointStatic {
    private static int value = 0;

    public int getValue() {
        return value; // omit this.
    }
    // build when the class has been built
    static {
        value++;
    }
    
}