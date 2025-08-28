package programmers.Level1.solution._79_유연근무제;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] schedules = { 700, 800, 1100 };
        int[][] timelog = {
                { 710, 2359, 1050, 700, 650, 631, 659 },
                { 800, 801, 805, 800, 759, 810, 809 },
                { 1105, 1001, 1002, 600, 1059, 1001, 1100 }
        };
        int startday = 5;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(schedules, timelog, startday);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        User[] users = new User[schedules.length];

        // User 객체 초기화
        for (int i = 0; i < schedules.length; i++) {
            users[i] = new User(schedules[i]);
        }

        int eventDays = timelogs[0].length; // 실제 이벤트 기간
        int currentDay = startday;

        for (int day = 0; day < eventDays; day++) {
            // 토요일(6), 일요일(7)은 체크하지 않음
            if (currentDay != 6 && currentDay != 7) {
                for (int i = 0; i < users.length; i++) {
                    // 이미 지각한 직원은 건너뜀
                    if (!users[i].isQualified) {
                        continue;
                    }

                    // 지각하면 즉시 실격 처리
                    if (timelogs[i][day] > users[i].deadline) {
                        users[i].isQualified = false;
                    }
                }
            }
            currentDay = (currentDay % 7) + 1;
        }

        // 자격을 유지한 직원 수 계산
        int answer = 0;
        for (User user : users) {
            if (user.isQualified) {
                answer++;
            }
        }

        return answer;
    }

    public class User {
        boolean isQualified;
        int schedule;
        int deadline;

        public User(int schedule) {
            this.schedule = schedule;
            this.deadline = addMinutes(schedule, 10);
            this.isQualified = true;
        }

        // User 클래스 내부에서 addMinutes 메소드를 사용하여 지각 시간을 미리 계산
        private int addMinutes(int time, int minutes) {
            int hour = time / 100;
            int min = time % 100;

            min += minutes;

            if (min >= 60) {
                hour += min / 60;
                min = min % 60;
            }

            return hour * 100 + min;
        }
    }
}
