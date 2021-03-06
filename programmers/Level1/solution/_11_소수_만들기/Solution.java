package programmers.Level1.solution._11_소수_만들기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * 1. 모든 배열의 합을 구한 뒤에 소수를 구해야 한다
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = { 1, 2, 7, 6, 4 };

        int result = solution.solution(test);
        System.out.println("결과: " + result);
    }

    public int solution(int[] nums) {
        int answer = 0;
        boolean isSosu = false;

        int count = nums.length;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    // 해당 배열의 3개의 값의 합
                    int totalNum = nums[i] + nums[j] + nums[k];
                    if (totalNum >= 2) {
                        // 소수 체크
                        isSosu = isSosuCheck(totalNum);
                    }
                    // 소수인 경우 개수 증가
                    if (isSosu) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isSosuCheck(int totalNum) {
        if (totalNum == 2) {
            return true;
        }
        for (int i = 2; i < totalNum; i++) {
            if (totalNum % i == 0) {
                return false;
            }
        }
        return true;
    }

}
