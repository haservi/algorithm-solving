package programmers.Level1.solution._51_삼총사;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Solution {

    public static void main(String[] args) {
        int[] number = { -3, -2, -1, 0, 1, 2, 3 };

        Solution solution = new Solution();
        int result = solution.solution(number);
        System.out.println("result: " + result);
    }

    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if ((number[i] + number[j] + number[k]) == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

}
