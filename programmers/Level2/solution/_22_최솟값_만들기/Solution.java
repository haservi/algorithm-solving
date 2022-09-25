package programmers.Level2.solution._22_최솟값_만들기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class Solution {

    public static void main(String[] args) {

        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };

        Solution solution = new Solution();
        int result = solution.solution(A, B);
        System.out.println("result: " + result);

    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 정렬 하여 최소와 최대값을 곱한 합
        Arrays.sort(A);
        Arrays.sort(B);
        // int[] primitive 타입은 아래와 같이 내림차순 정렬가능 
        // int[] sortedDesc = Arrays.stream(B)
        //         .boxed()
        //         .sorted(Collections.reverseOrder())
        //         .mapToInt(Integer::intValue)
        //         .toArray();

        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[(A.length - 1) - i]);
        }
        
        return answer;
    }
}
