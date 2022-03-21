package programmers.Level1.lv1_12_키패드_누르기;

public class Soulution {

    public static void main(String[] args) {
        int[] testNumber = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String testHand = "right";

        Soulution soulution = new Soulution();
        String result = soulution.solution(testNumber, testHand);

        System.out.println("결과: " + result);
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
}
