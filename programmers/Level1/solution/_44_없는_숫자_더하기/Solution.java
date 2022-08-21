package programmers.Level1.solution._44_없는_숫자_더하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class Solution {

    public static void main(String[] args) {

        int[] numbers = { 5, 8, 4, 0, 6, 7, 9 };

        Solution solution = new Solution();
        int result = solution.solution(numbers);

        System.out.println(result);
    }

    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] numberIndexCheck = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            int index = numbers[i];
            numberIndexCheck[index] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!numberIndexCheck[i])
                answer += i;
        }

        return answer;
    }

}
