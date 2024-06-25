package programmers.pccp.solution._10_아날로그_시계;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250135?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int h1 = 0;
        int m1 = 5;
        int s1 = 30;
        int h2 = 0;
        int m2 = 7;
        int s2 = 0;
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(h1, m1, s1, h2, m2, s2);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시간을 초로 변환
        int startTimeInSeconds = toSecond(h1, m1, s1);
        int endTimeInSeconds = toSecond(h2, m2, s2);

        // 두 시간 사이의 알람 울림 횟수 계산
        int totalAlarms = calculateAlarms(endTimeInSeconds) - calculateAlarms(startTimeInSeconds)
                + (isAlarmNow(startTimeInSeconds) ? 1 : 0);

        return totalAlarms;
    }

    private static int toSecond(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }

    // 주어진 시간까지 알람이 울리는 횟수를 계산하는 함수
    private static int calculateAlarms(int timeInSeconds) {
        // 분침과 초침이 겹치는 횟수 계산
        int minuteAlarms = timeInSeconds * 59 / 3600;
        // 시침과 초침이 겹치는 횟수 계산
        int hourAlarms = timeInSeconds * 719 / 43200;

        // 12:00:00에 알람이 울리는 횟수를 조정(최대 2번)
        int twelveHourPenalty = (timeInSeconds >= 43200) ? 2 : 1;

        return minuteAlarms + hourAlarms - twelveHourPenalty;
    }

    // 현재 시간에 알람이 울리는지 확인
    private static boolean isAlarmNow(int timeInSeconds) {
        return (timeInSeconds * 59 % 3600 == 0) || (timeInSeconds * 719 % 43200 == 0);
    }

}
