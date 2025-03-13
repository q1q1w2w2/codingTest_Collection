package test.interface1;

public class Str {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); // String constant Pool -> 같은거 재활용 -> true

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == str4); // Heap에 새로운 객체 생성 -> false
        
    }
}
