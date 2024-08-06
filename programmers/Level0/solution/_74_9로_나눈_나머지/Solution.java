package programmers.Level0.solution._74_9로_나눈_나머지;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181914?language=java
 */
class Solution {

    public static void main(String[] args) {
        String number = "78720646226947352489";
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(number);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String number) {
        int answer = 0;

        for (char digit : number.toCharArray()) {
            answer += digit - '0';
        }

        return answer % 9;
    }
}
