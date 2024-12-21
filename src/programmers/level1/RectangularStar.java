package programmers.level1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RectangularStar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        StringBuilder builder = new StringBuilder();
        IntStream.range(0, a).forEach(s -> builder.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(builder));
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < a; i++) {
//            builder.append("*");
//        }
//
//        for (int i = 0; i < b; i++) {
//            System.out.println(builder);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        for (int i = 0; i < b; i++) {
//            for (int j = 0; j < a; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
}
