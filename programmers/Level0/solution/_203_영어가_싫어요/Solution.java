package programmers.Level0.solution._203_영어가_싫어요;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120894?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String numbers = "onetwothreefourfivesixseveneightnine";
        long expectedResult = 123456789L;

        Solution solution = new Solution();
        long result = solution.solution(numbers);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long solution(String numbers) {
        String[] words = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < words.length; i++) {
            numbers = numbers.replace(words[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }

}
