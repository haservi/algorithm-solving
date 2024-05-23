package programmers.Level1.solution._04_체육복;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = { 2, 3 };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution1(n, lost, reserve);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];

        // 여벌의 체육복을 가지고 있는 학생 카운트 추가
        for (int studentNumber : reserve) {
            student[studentNumber - 1]++;
        }

        // 체육복을 잃은 학생 카운트 제거
        for (int studentNumber : lost) {
            student[studentNumber - 1]--;
        }

        // 체육복 배분
        for (int i = 0; i < student.length; i++) {
            if (student[i] < 0) {
                if (i != student.length - 1 && student[i + 1] > 0) {
                    student[i]++;
                    student[i + 1]--;
                } else if (i != 0 && student[i - 1] > 0) {
                    student[i]++;
                    student[i - 1]--;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < student.length; i++) {
            // 체육복을 가지고 있는 경우 학생 수 추가
            if (0 <= student[i]) {
                answer++;
            }
        }

        return answer;
    }

    // --------------------------------------------------------------

    public int solution1(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // lost, reserve을 set으로 변환하여 Set의 교집합 구함
        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        for (int l : lost) {
            q.add(l);
        }

        int get = 0;
        for (int r : reserve) {
            // 체육복을 가지고 있지만 체육복을 잃어버린 경우
            if (owns.contains(r)) {
                continue;
            }

            // queue는 비어있지 않고, 너무 멀리있거나 여벌옷이 있으면 빌릴 필요 없음
            while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }

            if (q.isEmpty()) {
                break;
            }

            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get;
    }

}
