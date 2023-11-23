package programmers.Level1.solution._03_신규_아이디_추천;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class Solution {

    public static void main(String[] args) {

        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String expectedResult = "bat.y.abcdefghi";

        Solution solution = new Solution();
        String result = solution.solution(new_id);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String new_id) {
        // 1단계 대문자를 소문자로 변경
        String step1 = new_id.toLowerCase();

        // 2단계 특정 문자제거
        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");

        // 3단계 중복되는 ".." 제거
        String step3 = step2.replaceAll("[..]{2,1000}", ".");

        // 4단계 아이디가 처음이나 끝에 "."가 있다면 제거
        String step4 = step3.replaceAll("(^\\.)|(\\.$)", "");

        // 5단계 만약 빈문자열이면 "a" 삽입
        String step5;
        if (step4.length() == 0) {
            step5 = "a";
        } else {
            step5 = step4;
        }

        // 6단계 문자의 길이가 16자 이상인 경우 15자까지 표현 및 마지막 .이 붙어있다면 제거
        String step6;
        if (step5.length() >= 16) {
            step6 = step5.substring(0, 15);
            step6 = step6.replaceAll("(\\.$)", "");
        } else {
            step6 = step5;
        }

        // 7단계 만약 길이가 2자이하라면 마지막 문자를 3글자까지 반복
        String step7 = step6;
        if (step7.length() <= 2) {
            while (step7.length() < 3) {
                step7 += step7.charAt(step7.length() - 1);
            }
        }

        String returnId = step7;

        return returnId;
    }

    public String solution2(String newId) {
        // 1단계: 영어를 소문자로
        newId = newId.toLowerCase();
        // 2단계: 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자 제거
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        // 3단계: 연속된 마침표를 하나의 마침표로 치환
        newId = newId.replaceAll("\\.+", ".");
        // 4단계: 처음이나 끝에 등장하는 마침표 제거
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        // 5단계: 빈 문자열일 경우 "a" 대입
        if (newId.isEmpty()) {
            newId = "a";
        }
        // 6단계: 길이가 16자 이상이면 앞 15개의 문자만 남기고, 문자열이 .으로 끝난다면 이를 제거
        if (16 <= newId.length() ) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }
        // 7단계: 문자열 길이가 3 이상이 될 때까지 마지막 문자 이어 붙이기
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        
        return newId;
    }

}
