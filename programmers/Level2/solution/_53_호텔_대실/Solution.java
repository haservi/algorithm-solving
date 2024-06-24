package programmers.Level2.solution._53_호텔_대실;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[][] bookTime = {
                { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" },
                { "14:10", "19:20" }, { "18:20", "21:20" }
        };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution1(bookTime);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[][] book_time) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // 시작 시간과 종료 시간을 분리하여 리스트에 추가
        for (String[] time : book_time) {
            String[] startToken = time[0].split(":");
            int startTime = Integer.parseInt(startToken[0]) * 60 + Integer.parseInt(startToken[1]);
            startTimes.add(startTime);

            // 종료시간에 10분 추가
            String[] endToken = time[1].split(":");
            int endTime = Integer.parseInt(endToken[0]) * 60 + Integer.parseInt(endToken[1]) + 10;
            endTimes.add(endTime);
        }

        // 시작 시간과 종료 시간 정렬
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int rooms = 0;
        int endTimeIndex = 0;

        // 시작 시간과 종료 시간을 비교하여 필요한 방의 수 계산
        for (int startTime : startTimes) {
            if (startTime < endTimes.get(endTimeIndex)) {
                // 새로운 방이 필요함
                rooms++;
            } else {
                // 기존 방을 사용할 수 있음
                endTimeIndex++;
            }
        }

        return rooms;
    }

    public int solution1(String[][] book_time) {
        List<Reservation> reservationList = new ArrayList<>();

        // 예약 시간을 Reservation 객체로 변환
        for (String[] time : book_time) {
            String[] startToken = time[0].split(":");
            int startTime = Integer.parseInt(startToken[0]) * 60 + Integer.parseInt(startToken[1]);

            String[] endToken = time[1].split(":");
            int endTime = Integer.parseInt(endToken[0]) * 60 + Integer.parseInt(endToken[1]) + 10; // 종료 시간에 10분 추가

            reservationList.add(new Reservation(startTime, endTime));
        }

        // 시작 시간 기준으로 예약 정렬
        Collections.sort(reservationList, (r1, r2) -> Integer.compare(r1.startTime, r2.startTime));

        // 방의 종료 시간을 관리하기 위한 우선순위 큐
        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();

        for (Reservation reservation : reservationList) {
            if (!endTimePQ.isEmpty() && endTimePQ.peek() <= reservation.startTime) {
                // 기존 방을 사용할 수 있음
                endTimePQ.poll();
            }
            // 새로운 종료 시간 추가(방의 개수)
            endTimePQ.offer(reservation.endTime);
        }

        // 필요한 방의 개수는 우선순위 큐의 크기
        return endTimePQ.size();
    }

    private class Reservation {
        private int startTime;
        private int endTime;

        private Reservation(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
