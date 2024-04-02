package programmers.Level2.solution._06_기능개발;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class Solution {
    public static void main(String[] args) {
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };
        int[] expectedResult = { 1, 3, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(progresses, speeds);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    class Task {
        int progress;
        int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    /**
     * 1. 가장 우선적인 기능이 완성되지 않으면 뒤의 기능이 이미 완성되어도 진행을 할 수 없음
     * 2. 그렇기 때문에 Queue와 반복문을 활용하여 가장 먼저 들어온 기능이 완료되면 순서대로 체크해서 카운트
     */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> queue = new LinkedList<Task>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Task(progresses[i], speeds[i]));
        }
        int day = 1;
        int progressCompleteCount = 0;
        List<Integer> completeList = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            Task task = queue.peek();
            int score = task.progress + (task.speed * day);
            if (100 <= score) {
                queue.poll();
                progressCompleteCount++;
                // 가장 마지막 값 삽입
                if (queue.isEmpty()) {
                    completeList.add(progressCompleteCount);
                }

            } else {
                if (progressCompleteCount != 0) {
                    completeList.add(progressCompleteCount);
                    progressCompleteCount = 0;
                }
                day++;
            }
        }
        // System.out.println(completeList.toString());
        return completeList.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);
            // 다음 작업 순서가 이전보다 오래 걸린 경우 이전 항목은 count 처리
            if (days < expiration) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }
        result.add(count);
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
