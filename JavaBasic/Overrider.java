package JavaBasic;
// 返回值和形参都不能改变 即外壳不变，核心重写！
public class Overrider {
    public static void main(String[] args) {
        DogMove dog = new DogMove();
        dog.move();
    }
}

class AnimalMove {
    public void move() {
        System.out.println("Animals could move.");
    }
}

class DogMove extends AnimalMove {
    @Override // able to omit
    public void move() {
        super.move();
        System.out.println("Dogs could move.");
    }
}