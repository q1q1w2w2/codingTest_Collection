package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(10)); // false
        System.out.println(isPalindrome(-121)); // false
    }

    /**
     * Palindrome: 좌우대칭 숫자
     * 문자열 변경 후 뒤집고 비교?
     */
    public static boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        String reverseStr = builder.reverse().toString();

        return reverseStr.equals(s);
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString().equals(s);
    }
}
