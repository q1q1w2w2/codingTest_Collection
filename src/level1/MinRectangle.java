package level1;

import java.util.Arrays;

public class MinRectangle {
    public static void main(String[] args) {
        MinRectangle clazz = new MinRectangle();
        int solution1 = clazz.solution1(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        int solution2 = clazz.solution1(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        int solution3 = clazz.solution1(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
        System.out.println("solution1 = " + solution1); // 4000
        System.out.println("solution2 = " + solution2); // 120
        System.out.println("solution3 = " + solution3); // 133
    }

    /**
     * 명함의 가로 세로 [width, height]
     * { {60, 50}, {30, 70}, {60, 30}, {80, 40} }
     * 모든 명함이 들어갈 수 있는 지갑의 크기를 반환(눕히는 것도 가능)
     *
     * 1. 큰 수를 width 위치로, 작은 수를 height 위치로
     * 2. width, height 중 각각 가장 큰 수 구하기
     */
    public int solution2(int[][] sizes) {

        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }

        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            if (maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }

        return maxWidth * maxHeight;
    }

    public int solution1(int[][] sizes) {

        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                if (maxWidth < sizes[i][0]) {
                    maxWidth = sizes[i][0];
                }
                if (maxHeight < sizes[i][1]) {
                    maxHeight = sizes[i][1];
                }
            } else {
                if (maxWidth < sizes[i][1]) {
                    maxWidth = sizes[i][1];
                }
                if (maxHeight < sizes[i][0]) {
                    maxHeight = sizes[i][0];
                }
            }

        }

        return maxWidth * maxHeight;
    }

    public int solution(int[][] sizes) {
        int length = 0;
        int height = 0;
        for (int[] size : sizes) {
            length = Math.max(length, Math.max(size[0], size[1]));
            height = Math.min(height, Math.min(size[0], size[1]));
        }
        return length * height;
    }
}
