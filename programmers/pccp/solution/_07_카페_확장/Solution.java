package programmers.pccp.solution._07_카페_확장;

/**
 * https://school.programmers.co.kr/learn/courses/15009/lessons/121689?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] menu = { 5, 12, 30 };
        int[] order = { 1, 2, 0, 1 };
        int k = 10;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(menu, order, k);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] menu, int[] order, int k) {
        Order[] orders = new Order[order.length];
        for (int i = 0; i < order.length; i++) {
            orders[i] = new Order(i * k, menu[order[i]]);
        }

        int max = 0;
        int time = 0;
        int end = 0;
        for (int start = 0; start < orders.length; start++) {
            Order o = orders[start];
            // 손님이 들어온 시간보다 time이 적은 경우 갱신
            if (time < o.time) {
                time = o.time;
            }
            // 걸린 시간 누적
            time += o.duration;
            // 대기하는 인원 확인
            while (end < orders.length && orders[end].time < time) {
                end++;
            }
            int count = end - start;
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    private static class Order {
        public final int time;
        public final int duration;

        public Order(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }
}
