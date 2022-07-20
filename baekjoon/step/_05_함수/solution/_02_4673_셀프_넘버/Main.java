package baekjoon.step._05_함수.solution._02_4673_셀프_넘버;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/4673
 */
public class Main {
    public static void main(String[] args) {
        boolean[] a = new boolean[10001];

        for (int i = 1; i < a.length; i++) {
            int n = d(i);

            if (n < 10001) {
                a[n] = true;
            }
        }

        // 셀프넘버인 값만 출력
        for (int i = 1; i < a.length; i++) {
            if (a[i] == false) {
                System.out.println(i);
            }
        }

    }

    /**
     * 자신의 앞의 d(n)을 찾아서 넘김
     * 자신의 앞의 d(n)은 이미 생성자를 거쳤기 때문에 해당 값은 셀프 넘버가 될 수 없다.
     */
    private static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}