package programmers.Level1.solution._55_카드_뭉치;

public class Solution {

    public static void main(String[] args) {
        String[] cards1 = { "i", "water", "drink" };
        String[] cards2 = { "want", "to" };
        String[] goal = { "i", "want", "to", "water", "drink" };

        Solution solution = new Solution();
        String result = solution.solution(cards1, cards2, goal);
        System.out.println("result: " + result);

    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;
        for (int i = 0; i < goal.length; i++) {
            if (cards1.length > card1Index && goal[i].equals(cards1[card1Index])) {
                card1Index++;
                continue;
            }
            if (cards2.length > card2Index && goal[i].equals(cards2[card2Index])) {
                card2Index++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }

}
