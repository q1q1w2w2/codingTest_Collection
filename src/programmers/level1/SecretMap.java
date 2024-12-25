package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretMap {
    public static void main(String[] args) {
        String[] solution1 = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
//        String[] solution2 = solution(3, new int[]{5, 7, 1}, new int[]{7, 1, 4});
        System.out.println("solution1 = " + Arrays.toString(solution1));
//        System.out.println("solution2 = " + Arrays.toString(solution2));
    }

    /**
     * 한 변의 길이가 n인 지도, 각 칸은 공백 또는 벽(#)으로 이루어짐
     * 전체 지도는 두 장의 지도를 겹쳐 얻을 수 있음
     * 둘 중 하나라도 벽이면 전체 지도에서 벽임
     * 0은 벽, 1은 공백
     * ex
     * n = 5
     * [9,20,28,18,11]
     * [30,1,21,17,28]
     * #####
     * # # #
     * ### #
     * # ##
     * #####
     * 2진수로 변환하여 각 자리마다 비교
     * 둘 다 0이라면 " ", 아니라면 #
     */
    public static String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] secretMap = new String[n];
        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toString(arr1[i], 2);
            String binary2 = Integer.toString(arr2[i], 2);
            // n 길이만큼 채워줘야 함
            binary1 = String.format("%" + n + "s", binary1).replace(' ', '0');
            binary2 = String.format("%" + n + "s", binary2).replace(' ', '0');

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < binary1.length(); j++) {
                if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0') {
                    builder.append(" ");
                } else {
                    builder.append("#");
                }
            }
            String line = builder.toString();
            secretMap[i] = line;
        }
        return secretMap;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replace("1", "#");
            result[i] = result[i].replace("0", " ");
        }
        return result;
    }

}
