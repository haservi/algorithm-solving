package baekjoon.problem._003_블랙_프라이데이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18114
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(weight, arr);
        System.out.println(result);
    }

    public static int solution(int weight, int[] products) throws Exception {
        // 제품 중에 무게가 일치한 값이 있는 경우 return 1
        for (int product : products) {
            if (weight == product) {
                return 1;
            }
        }
        // 제품을 오름차순으로 정렬
        Arrays.sort(products);

        int left = 0;
        int right = products.length - 1;
        while (left < right) {
            int sum = products[left] + products[right];
            if (sum == weight) {
                return 1;
            }

            // 값이 큰 경우 오른쪽 값 줄임
            if (weight < sum) {
                right--;
            } else {
                int mid = left + 1;
                // 숫자 3개를 선택한 경우
                while (mid < right) {
                    int threeSum = sum + products[mid];
                    mid++;
                    if (threeSum == weight) {
                        return 1;
                    }
                }
                left++;
            }
        }
        return 0;
    }

}
