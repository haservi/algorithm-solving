package programmers.Level1.solution._52_콜라_문제;

public class Solution {
    
    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;

        Solution solution = new Solution();
        int result = solution.solution(a, b, n);
        System.out.println("result: " + result);
    }

    public int solution(int a, int b, int n) {

        int answer = 0;
        int remainBottle = 0;
        while (a <= n) {
            // 교환후 남은 병
            remainBottle = n % a;
            // 현재 남은 병
            n = (n / a) * b;
            // 전체 교환 받은 병
            answer += n;
            // 교환 후 남은 병 합치기
            n += remainBottle;
        }
        return answer;

    }
}
