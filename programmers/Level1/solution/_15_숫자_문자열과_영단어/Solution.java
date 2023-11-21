package programmers.Level1.solution._15_숫자_문자열과_영단어;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution3("one4seveneightonezerozero");
        int expectedResult = 1478100;

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String s) {
        int answer = 0;

        char[] nums = s.toCharArray();
        int count = nums.length;
        String numberString = "";
        String resultString = "";
        for (int i = 0; i < count; i++) {
            int number = nums[i] - '0';

            // 숫자인 경우
            if (0 <= number && number <= 9) {
                resultString += nums[i];
                // 문자인 경우 반복하면서 확인 후 숫자로 변경
            } else {
                numberString += nums[i];
                int checkNumberString = getNumberStringToInt(numberString);
                if (checkNumberString != -1) {
                    resultString += String.valueOf(checkNumberString);
                    numberString = "";
                }
            }
        }
        answer = Integer.valueOf(resultString);

        return answer;
    }

    private int getNumberStringToInt(String numberString) {
        switch (numberString) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return -1;
        }
    }

    public int solution2(String s) {
        String[] digits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String[] alphabets = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(s);
    }

    /**
     * replaceAll의 경우 정규식으로도 활용할 수 있다.
     */
    public int solution3(String s) {
        String[] words = {
             "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 
        };

        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
