package programmers.Level0.solution._129_1로_만들기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181880?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 12, 4, 15, 1, 14 };
        int expectedResults = 11;

        Solution solution = new Solution();
        int result = solution.solution(num_list);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            answer += makeOne(num);
        }
        return answer;
    }

    private int makeOne(int num) {
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num - 1) / 2;
            }
            count++;
        }
        return count;
    }

}
