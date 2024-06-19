package programmers.Level2.solution._50_과제_진행하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[][] plans = {
                { "korean", "11:40", "30" },
                { "english", "12:10", "20" },
                { "math", "12:30", "40" }
        };
        String[] expectedResult = { "korean", "english", "math" };

        Solution solution = new Solution();
        String[] result = solution.solution(plans);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        for (String[] plan : plans) {
            tasks.add(new Task(
                    plan[0],
                    getStartTimeInMinutes(plan[1]),
                    Integer.parseInt(plan[2])));
        }
        tasks.sort((o1, o2) -> o1.time - o2.time);

        Stack<Task> stopTasks = new Stack<>();
        List<String> endTasks = new ArrayList<>();
        Task now = tasks.poll();
        int time = now.time;

        while (!tasks.isEmpty()) {
            time += now.studyTime;
            Task next = tasks.peek();

            // 과제 시간이 초과한 경우 다음 과제 진행
            if (time > next.time) {
                now.studyTime = time - next.time;
                stopTasks.push(now);
            } else {
                endTasks.add(now.subject);
                if (!stopTasks.empty()) {
                    now = stopTasks.pop();
                    continue;
                }
            }
            now = tasks.poll();
            time = now.time;
        }

        endTasks.add(now.subject);
        while (!stopTasks.empty()) {
            endTasks.add(stopTasks.pop().subject);
        }

        return endTasks.toArray(new String[0]);
    }

    private int getStartTimeInMinutes(String plan) {
        String[] hoursMinutes = plan.split(":");
        int startHours = Integer.parseInt(hoursMinutes[0]);
        int startMinutes = Integer.parseInt(hoursMinutes[1]);
        return startHours * 60 + startMinutes;
    }

    private static class Task {

        private String subject;
        private int time;
        private int studyTime;

        public Task(String subject, int startTime, int studyTime) {
            this.subject = subject;
            this.time = startTime;
            this.studyTime = studyTime;
        }

    }

}
