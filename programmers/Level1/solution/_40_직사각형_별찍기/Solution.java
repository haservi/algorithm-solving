package programmers.Level1.solution._40_직사각형_별찍기;

import java.util.Scanner;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12969
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        // System.out.println(a + b);
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
