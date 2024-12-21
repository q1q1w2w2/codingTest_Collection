package test.abstract1;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("DOG");
        Animal cat = new Cat("CAT");
        dog.showName();
        dog.sound();
        cat.showName();
        cat.sound();
    }
}
