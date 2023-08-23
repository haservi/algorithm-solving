package programmers.Level1.solution._67_옹알이;

public class Solution {

    public static void main(String[] args) {
        String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(babbling);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] babbling) {
        int answer = 0;
        String[] REMEMBER_SPEAK = { "aya", "ye", "woo", "ma" };

        for (String currentBabble : babbling) {
            // 연속적으로 말하는 경우 실패
            if (isSameWordTwice(currentBabble)) {
                continue;
            }

            while (!currentBabble.isEmpty()) {
                boolean foundMatch = false;

                for (String speak : REMEMBER_SPEAK) {
                    if (currentBabble.startsWith(speak)) {
                        currentBabble = currentBabble.substring(speak.length());
                        foundMatch = true;
                        break;
                    }
                }

                if (!foundMatch) {
                    break;
                }
            }

            if (currentBabble.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isSameWordTwice(String currentBabble) {
        return currentBabble.contains("ayaaya")
                || currentBabble.contains("yeye")
                || currentBabble.contains("woowoo")
                || currentBabble.contains("mama");
    }
}
