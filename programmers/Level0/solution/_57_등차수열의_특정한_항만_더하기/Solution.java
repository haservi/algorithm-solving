package programmers.Level0.solution._57_등차수열의_특정한_항만_더하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181931?language=java
 */
class Solution {

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        boolean[] included = { true, false, false, true, true };
        int expectedResult = 37;

        Solution solution = new Solution();
        int result = solution.solution(a, b, included);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += (a + (d * i));
            }
        }
        return answer;
    }
}
