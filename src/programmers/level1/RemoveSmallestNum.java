package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveSmallestNum {
    public static void main(String[] args) {
        RemoveSmallestNum clazz = new RemoveSmallestNum();
        int[] solution1 = clazz.solution(new int[]{4, 3, 2, 1});
        System.out.println("solution1 = " + Arrays.toString(solution1));
        int[] solution2 = clazz.solution(new int[]{10});
        System.out.println("solution2 = " + Arrays.toString(solution2));

        System.out.println(Arrays.toString(clazz.solution4(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(clazz.solution4(new int[]{1})));
    }

    /**
     * arr에서 제일 작은 수 제거해서 반환
     * 값이 하나면 [-1] 반환
     */
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        Integer min = null;
        for (int i : arr) {
            if (min == null || i < min) {
                min = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        int answerIdx = 0;
        int arrIdx = 0;
        while (arrIdx < answer.length) {
            if (arr[arrIdx] == min) {
                arrIdx++;
                continue;
            }
            answer[answerIdx++] = arr[arrIdx++];
        }
        return answer;
    }

    public int[] solution2(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i != min) {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        int size = 0;
        for (Integer i : list) {
            answer[size++] = i;
        }
        return answer;
    }

    public int[] solution3(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    public int[] solution4(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Integer min = Collections.min(list);
//        Arrays.sort(arr);
//        list.remove(list.indexOf(arr[0]));
        list.remove(min);
        return list.stream().mapToInt(i -> i).toArray();
    }

}
