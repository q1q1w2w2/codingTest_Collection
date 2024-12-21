package programmers.greedy;

import java.util.Arrays;
import java.util.HashSet;

public class WorkoutClothes {
    public static void main(String[] args) {
        WorkoutClothes clazz = new WorkoutClothes();
        int solution1 = clazz.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        int solution2 = clazz.solution(5, new int[]{2, 4}, new int[]{3});
        int solution3 = clazz.solution(3, new int[]{3}, new int[]{1});
        int solution4 = clazz.solution(4, new int[]{2, 3}, new int[]{3, 4});
        System.out.println("solution1 = " + solution1); // 5
        System.out.println("solution2 = " + solution2); // 4
        System.out.println("solution3 = " + solution3); // 2
        System.out.println("solution4 = " + solution4); // 3
    }

    /**
     * 총 몇 명이 체육복을 입을 수 있는가
     * 번호는 체격 순으로 매겨져 있으므로 바로 앞 또는 뒷번호 학생에게만 빌릴 수 있음
     * 최대한 많은 학생이 체육복을 입도록
     * n = 전체 학생 수
     * lost = 도난당한 학생
     * reserve = 빌려줄 수 있는 학생
     */
    public int solution1(int n, int[] lost, int[] reserve) {
        // lost 학생이 reserve 에서 최대한 많이 가져가도록
        // lost와 reserve에 둘 다 번호가 있는 경우는 두 곳 모두에서 제외시키고 answer++
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--; // 잃어버린 사람은 -1이 됨
        }
        for (int r : reserve) {
            people[r - 1]++; // 여분있는 사람은 1이 됨
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) { // 잃어버린 사람이면
                if (i - 1 >= 0 && people[i - 1] == 1) { // 앞사람 여분 확인
                    people[i]++; // 0이 됨
                    people[i - 1]--; // 여분있는 사람도 0이 됨
                } else if (i + 1 < people.length && people[i + 1] == 1) { // 뒷사람 여분 확인
                    people[i]++;
                    people[i + 1]--;
                } else { // 이러면 못빌리는거지
                    answer--;
                }
            }
        }
        return answer;
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        HashSet<Integer> reserveList = new HashSet<>();
        HashSet<Integer> lostList = new HashSet<>();

        for (int i : reserve) {
            reserveList.add(i);
        }
        for (int i : lost) {
            if (reserveList.contains(i)) {
                reserveList.remove(i);
            } else {
                lostList.add(i);
            }
        }
        for (int i : lost) {
            if (lostList.contains(i)) {
                if (reserveList.contains(i - 1)) {
                    reserveList.remove(i - 1);
                } else if (reserveList.contains(i + 1)) {
                    reserveList.remove(i + 1);
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}
