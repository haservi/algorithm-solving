package programmers.Level1.solution._13_3진법_뒤집기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 * 1. 십진법을 삼진법으로 바꾼 뒤 해당 값을 십진번으로 변경한다.
 */
class Solution {

    public static void main(String[] args) {
        int n = 125;
        int expectedResult = 229;

        Solution solution = new Solution();
        int result = solution.solution2(n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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

    public int solution2(int n) {
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
