package programmers.Level0.solution._92_물_부족;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340202?language=java
 */
class Solution {

    public static void main(String[] args) {
        int storage = 5141;
        int usage = 500;
        int[] change = { 10, -10, 10, -10, 10, -10, 10, -10, 10, -10 };
        int expectedResult = -1;

        Solution solution = new Solution();
        int result = solution.solution(storage, usage, change);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for (int i = 0; i < change.length; i++) {
            usage = usage + (usage * change[i] / 100);
            total_usage += usage;
            if (total_usage > storage) {
                return i;
            }
        }
        return -1;
    }
}
