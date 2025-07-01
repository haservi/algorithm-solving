package programmers.Level1.solution._78_택배_상자_꺼내기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/389478?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 13;
        int w = 3;
        int num = 9;
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(n, w, num);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, int w, int num) {
        // num이 속한 행과 해당 행에서의 위치 계산
        int targetRow = (num - 1) / w;
        int positionInRow = (num - 1) % w;

        // 지그재그 패턴에 따른 실제 열 위치 계산
        int targetColumn = (targetRow % 2 == 0) ? positionInRow : w - 1 - positionInRow;

        // 총 행 수 계산
        int totalRows = (n + w - 1) / w;

        // 위에 있는 상자들 개수 계산 (자기 자신 포함)
        int count = 1;

        for (int row = targetRow + 1; row < totalRows; row++) {
            int remainingBoxes = n - (row * w);
            if (remainingBoxes <= 0) {
                break;
            }

            int boxesInRow = Math.min(w, remainingBoxes);

            // 해당 행에서 target column에 상자가 있는지 확인
            if (row % 2 == 0) {
                // 짝수 행: 왼쪽부터 채워짐
                if (targetColumn < boxesInRow) {
                    count++;
                }
            } else {
                // 홀수 행: 오른쪽부터 채워짐
                if (targetColumn >= w - boxesInRow) {
                    count++;
                }
            }
        }

        return count;
    }

}
