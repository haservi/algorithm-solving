package programmers.Level1.solution._54_푸드_파이트_대회;

public class Solution {

    public static void main(String[] args) {
        int[] food = { 1, 3, 5, 6 };
        Solution solution = new Solution();
        String result = solution.solution(food);
        System.out.println("result: " + result);
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int repeat = food[i] / 2;
            for (int j = 0; j < repeat; j++) {
                sb.append(i);
            }
        }
        StringBuilder sbReverse = new StringBuilder(sb);
        sbReverse.reverse();
        return sb.toString() + "0" + sbReverse.toString();
    }
}
