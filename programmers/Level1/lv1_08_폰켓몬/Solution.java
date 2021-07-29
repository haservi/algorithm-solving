package programmers.Level1.lv1_08_폰켓몬;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] animals = { 1, 2, 3, 1, 4, 1, 4, 1 };
        int result = solution.solution(animals);
        System.out.println("얻을 수 있는 동물의 수 : " + result);
    }

    public int solution(int[] nums) {
        // 절반 이상 선택할 수 없음
        int answer = 0;
        int selectMaxCount = nums.length / 2;
        // 해당 번호가 겹치지 않은 배열을 만듬
        int totalCount = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < totalCount; i++) {
            if (selectMaxCount == answer) {
                break;
            }
            if (i == 0) {
                answer++;
            } else if (nums[i - 1] != nums[i]) {
                answer++;
            }
        }
        return answer;
    }

}
