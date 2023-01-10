package programmers.Level1.solution._53_크기가_작은_부분_문자열;

public class Solution {

    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";

        Solution solution = new Solution();
        int result = solution.solution(t, p);
        System.out.println("result: " + result);
    }

    public int solution(String t, String p) {
        int length = t.length() - p.length();
        int answer = 0;
        long pLong = Long.parseLong(p);

        for (int i = 0; i <= length; i++) {
            long tSubstringLong = Long.parseLong(t.substring(i, p.length() + i));
            if (tSubstringLong <= pLong) {
                answer++;
            }
        }
        return answer;
    }
}
