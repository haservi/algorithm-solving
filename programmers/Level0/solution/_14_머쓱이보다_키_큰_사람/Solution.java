package programmers.Level0.solution._14_머쓱이보다_키_큰_사람;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120585
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = { 49, 180, 192, 170 };
        int height = 167;

        Solution solution = new Solution();
        int result = solution.solution(array, height);
        System.out.println("result: " + result);
    }

    public int solution(int[] array, int height) {
        int answer = 0;
        for (int userHeight : array) {
            if (height < userHeight) {
                answer++;
            }
        }
        return answer;
    }

}
