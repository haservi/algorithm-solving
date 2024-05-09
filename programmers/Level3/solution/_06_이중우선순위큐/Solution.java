package programmers.Level3.solution._06_이중우선순위큐;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {

        String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        int[] expectedResult = { 333, -45 };

        Solution solution = new Solution();
        int[] result = solution.solution1(operations);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");

            if (split[0].equals("I")) {
                minPq.add(Integer.parseInt(split[1]));
                maxPq.add(Integer.parseInt(split[1]));

            } else if (split[0].equals("D")) {
                if (!minPq.isEmpty()) {
                    if (Integer.parseInt(split[1]) < 0) {
                        int min = minPq.poll();
                        maxPq.remove(min);
                    } else {
                        int max = maxPq.poll();
                        minPq.remove(max);
                    }
                }
            }
        }

        if (minPq.size() > 0) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }

        return answer;
    }

    // --------------------------------
    public int[] solution1(String[] operations) {
        DoublyPriorityQueue dpq = new DoublyPriorityQueue();
        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];
            switch (command) {
                case "I" -> dpq.add(Integer.parseInt(value));
                case "D" -> {
                    if (value.equals("1")) {
                        dpq.removeMax();
                    } else if (value.equals("-1")) {
                        dpq.removeMin();
                    }
                }
            }
        }
        return new int[] { dpq.max(), dpq.min() };
    }

    private static class DoublyPriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public void add(int value) {
            minPq.add(value);
            maxPq.add(value);
            size++;
        }

        public void removeMax() {
            if (size == 0) {
                return;
            }
            maxPq.poll();
            if (--size == 0) {
                minPq.clear();
                maxPq.clear();
            }
        }

        public void removeMin() {
            if (size == 0) {
                return;
            }
            minPq.poll();
            if (--size == 0) {
                minPq.clear();
                maxPq.clear();
            }
        }

        public int max() {
            if (size == 0) {
                return 0;
            }
            return maxPq.peek();
        }

        public int min() {
            if (size == 0) {
                return 0;
            }
            return minPq.peek();
        }
    }
}