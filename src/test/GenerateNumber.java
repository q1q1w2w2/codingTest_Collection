package test;

import java.util.Random;

public class GenerateNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateNumber());
        }
    }

    private static String generateNumber() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
