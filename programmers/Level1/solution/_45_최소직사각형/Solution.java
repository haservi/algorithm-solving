package programmers.Level1.solution._45_최소직사각형;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] sizes = {
                { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 }
        };
        int result = solution.solution(sizes);
        System.out.println(result);
    }

    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for (int i = 0; i < sizes.length; i++) {
            // 해당 인덱스의 최대길이, 최소길이를 확인
            int maxWidth = Math.max(sizes[i][0], sizes[i][1]);
            int minHeight = Math.min(sizes[i][0], sizes[i][1]);
            // 각각의 사이즈에서 가진 최대값을 할당
            width = Math.max(width, maxWidth);
            height = Math.max(height, minHeight);
        }
        return width * height;
    }

}
