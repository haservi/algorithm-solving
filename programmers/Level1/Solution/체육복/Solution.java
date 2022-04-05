package programmers.Level1.Solution.체육복;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int totalStudent = 5;
        int[] lostStudents = { 4, 5 };
        int[] reserveStudents = { 1, 4 };

        int result = solution.solution(totalStudent, lostStudents, reserveStudents);
        System.out.println("결과: " + result + "명");
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];

        // 여벌의 체육복을 가지고 있는 학생 카운트 추가
        for (int studentNumber : reserve) {
            student[studentNumber - 1]++;
        }

        // 체육복을 잃은 학생 카운트 제거
        for (int studentNumber : lost) {
            student[studentNumber - 1]--;
        }

        // 체육복 배분
        for (int i = 0; i < student.length; i++) {
            if (student[i] < 0) {
                if (i != student.length - 1 && student[i + 1] > 0) {
                    student[i]++;
                    student[i + 1]--;
                } else if (i != 0 && student[i - 1] > 0) {
                    student[i]++;
                    student[i - 1]--;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < student.length; i++) {
            // 체육복을 가지고 있는 경우 학생 수 추가
            if (0 <= student[i]) {
                answer++;
            }
        }

        return answer;
    }

}