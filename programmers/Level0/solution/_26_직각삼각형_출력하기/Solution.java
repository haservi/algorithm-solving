package programmers.Level0.solution._26_직각삼각형_출력하기;

import java.util.Scanner;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120823
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }

}
