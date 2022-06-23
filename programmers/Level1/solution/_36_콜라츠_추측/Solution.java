package programmers.Level1.solution._36_콜라츠_추측;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 * 1. 반복적으로 돌면서 짝수이면 2로 나누고 홀수이면 해당값에 3을 곱한 후 1을 더해준다.
 * 2. 해당 반복이 500회가 되면 -1을 리턴한다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int num = 626331;

        int result = solution.solution(num);
        System.out.println("결과 : " + result);
    }

    public int solution(long num) {
        int answer = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }
            answer++;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }
}
