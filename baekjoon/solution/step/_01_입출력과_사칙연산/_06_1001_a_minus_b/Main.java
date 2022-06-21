package baekjoon.solution.step._01_입출력과_사칙연산._06_1001_a_minus_b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        System.out.println(A - B);

        in.close();
    }
}