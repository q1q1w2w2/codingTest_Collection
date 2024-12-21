package test.abstract1;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    void sound() {
        System.out.println("Bark");
    }
}
