package programmers.Level0.solution._41_특정_문자_제거하기;

public class Solution {

    public static void main(String[] args) {
        String my_string = "abbBcvd";
        String letter = "b";

        Solution solution = new Solution();
        String result = solution.solution(my_string, letter);
        System.out.println("result: " + result);
    }
    
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}
