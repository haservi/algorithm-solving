package programmers.Level0.solution._105_조건에_맞게_수열_변환하기_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181881?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 100, 99, 98 };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(arr);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] arr) {
        int answer = 0;
        boolean isChanged = true;

        while (isChanged) {
            isChanged = false;
            int[] temp = arr.clone();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    temp[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    temp[i] = (arr[i] * 2) + 1;
                } else {
                    temp[i] = arr[i];
                }

                // 값이 변경되었다면 플래그 변경
                if (temp[i] != arr[i]) {
                    isChanged = true;
                }
            }

            arr = temp;
            if (isChanged) {
                answer++;
            }
        }

        return answer;
    }

}
