package programmers.Level1.삼진법_뒤집기;

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