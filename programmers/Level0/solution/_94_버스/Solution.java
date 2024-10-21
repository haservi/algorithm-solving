package programmers.Level0.solution._94_버스;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340201?language=java
 */
class Solution {

    public static void main(String[] args) {
        int seat = 5;
        String[][] passengers = { { "On", "On", "On" }, { "Off", "On", "-" }, { "Off", "-", "-" } };

        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(seat, passengers);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;
        for (int i = 0; i < passengers.length; i++) {
            num_passenger += func4(passengers[i]);
            num_passenger -= func3(passengers[i]);
        }
        int answer = func1(seat - num_passenger);
        return answer;
    }

    public int func1(int num) {
        if (0 > num) {
            return 0;
        } else {
            return num;
        }
    }

    public int func3(String[] station) {
        int num = 0;
        for (int i = 0; i < station.length; i++) {
            if (station[i].equals("Off")) {
                num += 1;
            }
        }
        return num;
    }

    public int func4(String[] station) {
        int num = 0;
        for (int i = 0; i < station.length; i++) {
            if (station[i].equals("On")) {
                num += 1;
            }
        }
        return num;
    }
}
