package baekjoon.step._02_조건문._01_1330_두_수_비교하기;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1330
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if (a > b)
            System.out.println(">");
        else if (a < b)
            System.out.println("<");
        else if (a == b)
            System.out.println("==");

    }
}