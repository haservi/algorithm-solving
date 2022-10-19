package programmers.Level0.solution._36_최빈값_구하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 3, 3, 4 };

        Solution solution = new Solution();
        int result = solution.solution(array);
        System.out.println("result: " + result);
    }

    public int solution(int[] array) {
        int answer = 0;
        int[] index = new int[1000];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            index[array[i]]++;
        }

        for (int i = 0; i < index.length; i++) {
            if (max < index[i]) {
                max = index[i];
                answer = i;
            }
        }

        // 최대값이 없는 경우 -1
        if (max == Integer.MIN_VALUE) {
            return -1;
        }

        // 중복되는 숫자가 있는 경우 -1
        boolean isDuplicated = false;
        for (int number : index) {
            if (max == number) {
                if (isDuplicated) {
                    return -1;
                }
                isDuplicated = true;
            }
        }

        return answer;
    }

}
