package programmers.Level0.solution._84_전국_대회_선발_고사;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181851?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] rank = { 3, 7, 2, 5, 4, 6, 1 };
        boolean[] attendance = { false, true, true, true, true, false, false };
        int expectedResult = 20403;

        Solution solution = new Solution();
        int result = solution.solution(rank, attendance);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] rank, boolean[] attendance) {
        // 출석이 true인 인덱스를 저장할 리스트
        List<Integer> presentIndices = new ArrayList<>();

        // 출석이 true인 인덱스 저장
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                presentIndices.add(i);
            }
        }

        // 인덱스에 해당하는 랭크를 오름차순으로 정렬
        presentIndices.sort(Comparator.comparingInt(i -> rank[i]));

        // 상위 3개의 인덱스 선택 및 점수 계산
        return presentIndices.get(0) * 10000
                + presentIndices.get(1) * 100
                + presentIndices.get(2);
    }

}
