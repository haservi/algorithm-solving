package programmers.Level0.solution._138_날짜_비교하기;

import java.time.LocalDate;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181838?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] date1 = { 2021, 12, 28 };
        int[] date2 = { 2021, 12, 29 };
        int expectedResults = 1;

        Solution solution = new Solution();
        int result = solution.solution(date1, date2);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] date1, int[] date2) {
        for (int i = 0; i < 3; i++) {
            if (date1[i] < date2[i]) {
                return 1;
            } else if (date1[i] > date2[i]) {
                return 0;
            }
        }
        return 0;
    }

    public int solution2(int[] date1, int[] date2) {
        LocalDate d1 = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate d2 = LocalDate.of(date2[0], date2[1], date2[2]);

        return d1.isBefore(d2) ? 1 : 0;
    }

}
