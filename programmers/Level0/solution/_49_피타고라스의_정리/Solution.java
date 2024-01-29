package programmers.Level0.solution._49_피타고라스의_정리;

import java.util.Scanner;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250132
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (c * c) - (a * a);

        System.out.println(b_square);
    }
}
