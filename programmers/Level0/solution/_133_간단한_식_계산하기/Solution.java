package programmers.Level0.solution._133_간단한_식_계산하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181865?language=java
 */
class Solution {

    public static void main(String[] args) {
        String binomial = "43 + 12";
        int expectedResults = 55;

        Solution solution = new Solution();
        int result = solution.solution(binomial);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String binomial) {
        String[] splits = binomial.split(" ");
        int operand1 = Integer.parseInt(splits[0]);
        int operand2 = Integer.parseInt(splits[2]);
        String operator = splits[1];

        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

}
