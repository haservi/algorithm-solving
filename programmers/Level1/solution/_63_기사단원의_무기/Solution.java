package programmers.Level1.solution._63_기사단원의_무기;

public class Solution {

    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;
        int expectedResult = 10;

        Solution solution = new Solution();
        int result = solution.solution(number, limit, power);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numberPowers = getDivisorSumArray(number);
        for (int i = 1; i <= number; i++) {
            if (limit < numberPowers[i]) {
                answer += power;
            } else {
                answer += numberPowers[i];
            }
        }
        return answer;
    }

    private int[] getDivisorSumArray(int number) {
        int[] counts = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                counts[i * j]++;
            }
        }
        return counts;
    }

    // 하나하나 구하면 속도가 느려서 통과를 못함
    // private int getDivisorSum(int number) {
    //     int count = 0;
    //     for (int i = 1; i <= number; i++) {
    //         if (number % i == 0)
    //             count++;
    //     }
    //     return count;
    // }
}
