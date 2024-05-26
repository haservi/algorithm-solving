package programmers.Level2.solution._45_주차_요금_계산;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        int[] expectedResult = { 14600, 34400, 5000 };

        Solution solution = new Solution();
        int[] result = solution.solution(fees, records);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);

        Map<String, Car> cars = new HashMap<>();
        // 차량 객체 생성
        // 차량의 요금 계산
        for (String record : records) {
            String[] tokens = record.split(" ");
            int time = parseTime(tokens[0]);
            String carNumber = tokens[1];
            boolean isIn = tokens[2].equals("IN");

            if (!cars.containsKey(carNumber)) {
                cars.put(carNumber, new Car(carNumber, fee));
            }

            Car car = cars.get(carNumber);
            if (isIn) {
                car.in(time);
            } else {
                car.out(time);
            }
        }

        // 차량이 OUT인 경우 마지막 시간까지 계산
        int endTime = parseTime("23:59");
        for (Car car : cars.values()) {
            car.out(endTime);
        }

        return cars.values().stream().sorted(Comparator.comparing(car -> car.carNumber))
                .mapToInt(Car::cost)
                .toArray();
    }

    private int parseTime(String time) {
        String[] tokens = time.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minute = Integer.parseInt(tokens[1]);
        return (hour * 60) + minute;
    }

    private static class Fee {
        private final int baseTime;
        private final int baseFee;
        private final int unitTime;
        private final int unitFee;

        private Fee(int baseTime, int baseFee, int unitTime, int unitFee) {
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }

        private int cost(int time) {
            int fee = baseFee;
            time -= baseTime;

            while (time > 0) {
                fee += unitFee;
                time -= unitTime;
            }

            return fee;
        }
    }

    private static class Car {
        private final String carNumber;
        private final Fee fee;
        private int inTime = -1;
        private int totalTime = 0;

        public Car(String carNumber, Fee fee) {
            this.carNumber = carNumber;
            this.fee = fee;
        }

        public void in(int time) {
            this.inTime = time;
        }

        public void out(int time) {
            if (this.inTime == -1) {
                return;
            }
            totalTime += time - this.inTime;
            this.inTime = -1;
        }

        private int cost() {
            return fee.cost(totalTime);
        }
    }

}
