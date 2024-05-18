package programmers.Level1.solution._09_키패드_누르기;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java
 * 1. 이전 번호의 숫자를 누른 손가락의 위치와 왼손잡이인지 오른손잡이인지에 따른 좌표를 표현한다.
 * 2. 휴대폰의 위치에 따라 정해진 좌표값이 있으니 그에 맞게 값을 출력하면 된다.
 */
public class Solution {

    public static void main(String[] args) {
        int[] testNumber = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String testHand = "right";
        String expectedResult = "LRLLLRLLRRL";

        Solution soulution = new Solution();
        String result = soulution.solution1(testNumber, testHand);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 시작 전 엄지 손가락의 위치
        int leftHandNumber = 10;
        int rightHandNumber = 12;

        for (int number : numbers) {
            if (number == 0) {
                number += 11;
            }

            switch (number % 3) {
                case 0:
                    answer += "R";
                    rightHandNumber = number;
                    break;
                case 1:
                    answer += "L";
                    leftHandNumber = number;
                    break;
                case 2:
                    int distanceLeft = getDistance(number, leftHandNumber);
                    int distanceRight = getDistance(number, rightHandNumber);

                    if (distanceRight < distanceLeft) {
                        answer += "R";
                        rightHandNumber = number;
                    } else if (distanceLeft < distanceRight) {
                        answer += "L";
                        leftHandNumber = number;
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightHandNumber = number;
                        } else if (hand.equals("left")) {
                            answer += "L";
                            leftHandNumber = number;
                        } else {
                            System.out.println("error: " + hand);
                        }
                    }
            }
        }
        return answer;
    }

    /**
     * 손의 위치와 들어온 숫자의 거리 값 출력
     * 
     * @param number
     * @param handDistance
     * @return
     */
    public int getDistance(int number, int handDistance) {
        int result = (Math.abs(number - handDistance)) / 3 + (Math.abs(number - handDistance)) % 3;
        return result;
    }

    public String solution1(int[] numbers, String hand) {
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        return Arrays.stream(numbers)
                .mapToObj(n -> press(n, right, left).hand)
                .collect(Collectors.joining());
    }

    private static class Hand {
        private final int baseX;
        private final String hand;
        private final float preference;
        private int x;
        private int y;

        private Hand(String hand, boolean isPreferred, int x) {
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreferred ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        private float distance(int x, int y) {
            if (x == baseX)
                return 0;
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - preference;
        }

        private void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getX(int number) {
        if (number == 0) {
            return 1;
        }
        return (number - 1) % 3;
    }

    private int getY(int number) {
        if (number == 0) {
            return 3;
        }
        return (number - 1) / 3;
    }

    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = right;
        if (lDistance < rDistance) {
            hand = left;
        }
        hand.move(x, y);
        return hand;
    }

}
