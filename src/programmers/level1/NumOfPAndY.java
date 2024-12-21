package programmers.level1;

public class NumOfPAndY {
    public static void main(String[] args) {
        NumOfPAndY numOfPAndY = new NumOfPAndY();
        boolean solution1 = numOfPAndY.solution("pPoooyY");
        boolean solution2 = numOfPAndY.solution("Pyy");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    // s의 p, y 개수를 비교해 같으면 true 다르면 false(대소문자 구분x)
    public boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                count++;
            } else if (s.charAt(i) == 'y') {
                count--;
            }
        }
        return count == 0;
    }

    public boolean solution1(String s) {
        s = s.toLowerCase();
        return s.chars().filter(e -> 'p'==e).count() == s.chars().filter(e -> 'y'==e).count();
    }
}
