package test.abstract1;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void sound();

    void showName() {
        System.out.println("name = " + name);
    }
}
