package baekjoon.step._03_반복문.solution._13_10951_a_plus_b_minus_4;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10951
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a + b);
        }
        sc.close();
    }

}