package programmers.Level0.solution._191_특별한_이차원_배열_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181831?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] arr = {
                {5, 192, 33},
                {192, 72, 95},
                {33, 95, 999}
        };
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(arr);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }

        return 1;
    }
}
