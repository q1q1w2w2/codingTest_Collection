package test.abstract1;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    void sound() {
        System.out.println("Meow");
    }
}
