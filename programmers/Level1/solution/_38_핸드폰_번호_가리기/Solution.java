package programmers.Level1.solution._38_핸드폰_번호_가리기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 * 1. 해당 문자열의 길이를 가져온 뒤 4만큼 뺀 길이 이후의 문자는 모두 `*` 처리하도록 구현했다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String num = "027778888";

        String result = solution.solution(num);
        System.out.println("결과 : " + result);
    }

    public String solution(String phone_number) {
        int startMaking = phone_number.length() - 4;
        String regex = "(?<=.{" + startMaking + "}).";
        phone_number = phone_number.replaceAll(regex, "*");
        return phone_number;
    }
}
