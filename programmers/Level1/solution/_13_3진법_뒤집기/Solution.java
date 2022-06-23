package programmers.Level1.solution._13_3진법_뒤집기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 * 1. 십진법을 삼진법으로 바꾼 뒤 해당 값을 십진번으로 변경한다.
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(125);
        System.out.println("결과 : " + result);
    }

    public int solution(int number) {
        String change = reverseTenToThree(number);
        int result = convertThreeToTen(change);
        return result;
    }

    private String reverseTenToThree(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        while (0 < number) {
            stringBuilder.append(number % 3);
            number = number / 3;
        }

        return stringBuilder.toString();
    }

    private int convertThreeToTen(String number) {
        char[] nums = number.toCharArray();

        int result = 0;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            result = result * 3 + (nums[i] - '0');
        }
        return result;
    }
}