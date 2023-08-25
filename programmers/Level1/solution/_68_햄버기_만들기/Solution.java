package programmers.Level1.solution._68_햄버기_만들기;

public class Solution {

    public static void main(String[] args) {
        int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(ingredient);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] ingredient) {
        int answer = 0;

        final int BUGER_LENGTH = 4;
        int[] bugerItems = new int[ingredient.length];
        int index = 0;
        for (int item : ingredient) {
            bugerItems[index] = item;
            index++;

            if (BUGER_LENGTH <= index) {
                if (bugerItems[index - 4] == 1
                        && bugerItems[index - 3] == 2
                        && bugerItems[index - 2] == 3
                        && bugerItems[index - 1] == 1) {
                    index -= 4;
                    answer++;
                }
            }
        }
        return answer;
    }

}
