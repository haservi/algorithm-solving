package programmers.Level2.solution._06_기능개발;

import java.util.*;

/**
 * 1. 가장 우선적인 기능이 완성되지 않으면 뒤의 기능이 이미 완성되어도 진행을 할 수 없다.
 * 2. 그렇기 때문에 Queue와 반복문을 활용하여 가장 먼저 들어온 기능이 완료되면 순서대로 체크해서 카운트하면 된다.
 * 3. 앞의 프린터 문제를 풀면서 Queue에 클래스 객체를 넣는 방식으로 코드를 수정하였다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        int[] result = solution.solution(progresses, speeds);
        System.out.println("결과: " + Arrays.toString(result));
    }

    class Task {
        int progress;
        int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

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
}
