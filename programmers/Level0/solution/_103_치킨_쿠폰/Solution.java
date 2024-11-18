package programmers.Level0.solution._103_치킨_쿠폰;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120884?language=java
 */
class Solution {

    public static void main(String[] args) {
        int chicken = 1081;
        int expectedResult = 120;

        Solution solution = new Solution();
        int result = solution.solution(chicken);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        while (coupon >= 10) {
            answer += coupon / 10;
            coupon = (coupon % 10) + (coupon / 10);
        }
        return answer;
    }
}
