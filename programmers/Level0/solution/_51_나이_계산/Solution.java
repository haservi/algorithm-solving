package programmers.Level0.solution._51_나이_계산;

import java.util.Scanner;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250131
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int year = sc.nextInt();
            String age_type = sc.next();
            int answer = 0;

            if (age_type.equals("Korea")) {
                answer = 2030 - year + 1;

            } else if (age_type.equals("Year")) {
                answer = 2030 - year;
            }

            System.out.println(answer);
        }
    }
}
