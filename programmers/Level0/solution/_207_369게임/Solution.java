package programmers.Level0.solution._207_369게임;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120891?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        int order = 29423;
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(order);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int order) {
        int count = 0;

        String number = String.valueOf(order);

        for (char digit : number.toCharArray()) {
            if ("369".indexOf(digit) >= 0) {
                count++;
            }
        }

        return count;
    }
}
