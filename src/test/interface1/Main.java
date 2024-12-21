package test.interface1;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square(); // 객체이면서, 각각 클래스의 인스턴스

        circle.draw();
        square.draw();
    }
}
