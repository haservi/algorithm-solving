package programmers.Level0.solution._139_주사위의_개수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120845?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] box = { 1, 1, 1, };
        int n = 1;
        int expectedResults = 1;

        Solution solution = new Solution();
        int result = solution.solution(box, n);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] box, int n) {
        int maxWidth = box[0] / n;
        int maxLength = box[1] / n;
        int maxHeight = box[2] / n;
        int answer = maxWidth * maxLength * maxHeight;
        return answer;
    }
}
