package test;

public class ConcatCompare {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String a = "";
        for (int i = 0; i < 10000; i++) {
            a += "i";
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        String b = new String("");
        for (int i = 0; i < 10000; i++) {
            b += "i";
        }

        end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("i");
        }
        String c = builder.toString();

        end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");
    }
}
