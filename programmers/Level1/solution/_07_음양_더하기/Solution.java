package programmers.Level1.solution._07_음양_더하기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 * 1. 제한 사항으로 길이가 같기 때문에 signs 배열의 true false에 따라 음양값만 정한 후 모든 값을 더해주면 된다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] absolutes = { 1, 2, 3 };
        boolean[] signs = { true, false, true };

        int result = solution.solution(absolutes, signs);
        System.out.println("결과값 : " + result);
    }

    private int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int count = absolutes.length;
        for (int i = 0; i < count; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
