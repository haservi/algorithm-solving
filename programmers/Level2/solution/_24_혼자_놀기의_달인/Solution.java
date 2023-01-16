package programmers.Level2.solution._24_혼자_놀기의_달인;

public class Solution {

    public static void main(String[] args) {
        int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 };

        Solution solution = new Solution();
        int result = solution.solution(cards);
        System.out.println("result: " + result);
    }

    public int solution(int[] cards) {
        int box1 = Integer.MIN_VALUE;
        int box2 = Integer.MIN_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == 0) {
                continue;
            }

            int boxCheck = openBox(cards, i);
            if (box1 < boxCheck) {
                box2 = box1;
                box1 = boxCheck;
            } else if (box2 < boxCheck) {
                box2 = boxCheck;
            }
        }

        return box1 * box2;
    }

    private static int openBox(int[] cards, int index) {
        int count = 0;
        while (cards[index] != 0) {
            int nextIndex = cards[index] - 1;
            cards[index] = 0;
            index = nextIndex;
            count++;
        }

        return count;
    }

}
