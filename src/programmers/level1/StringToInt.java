package programmers.level1;

public class StringToInt {
    public static void main(String[] args) {
        StringToInt stringToInt = new StringToInt();
        int solution = stringToInt.solution("1000");
        System.out.println(solution);
    }

    public int solution(String s) {
        Integer i = Integer.valueOf(s); // 객체를 반환하므로 비교적 느림
        return Integer.parseInt(s);
    }
}
