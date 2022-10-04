package programmers.Level0.solution._19_옷_가게_할인_받기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120818
 */
public class Solution {

    public static void main(String[] args) {
        int price = 150000;

        Solution solution = new Solution();
        int result = solution.solution(price);
        System.out.println("result: " + result);
    }

    public int solution(int price) {
        double salePercent = salePercent(price);
        int answer = (int) (price - (price * salePercent));
        return answer;
    }

    public double salePercent(int price) {
        if (100000 <= price && price < 300000) {
            return 0.05;
        }
        if (300000 <= price && price < 500000) {
            return 0.10;
        }
        if (500000 <= price) {
            return 0.20;
        }
        return 0;
    }

}
