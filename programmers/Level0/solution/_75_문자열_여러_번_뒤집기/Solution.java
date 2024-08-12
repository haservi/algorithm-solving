package programmers.Level0.solution._75_문자열_여러_번_뒤집기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181913?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "rermgorpsam";
        int[][] queries = { { 2, 3 }, { 0, 7 }, { 5, 9 }, { 6, 10 } };
        String expectedResult = "programmers";

        Solution solution = new Solution();
        String result = solution.solution(my_string, queries);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return new String(arr);
    }
}
