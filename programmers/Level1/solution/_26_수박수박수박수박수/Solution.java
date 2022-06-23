package programmers.Level1.solution._26_수박수박수박수박수;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;

        String result = solution.solution(n);
        System.out.println("결과 : " + result);
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        while (n > count) {
            count++;
            if (count % 2 == 1) {
                answer.append("수");
            } else {
                answer.append("박");
            }
        }
        return answer.toString();
    }
}
