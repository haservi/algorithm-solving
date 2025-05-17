package baekjoon.problem._025_오리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/12933
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String duckSounds = br.readLine();

            int result = solution(duckSounds);
            System.out.println(result);

            br.close();
        }
    }

    private static int solution(String duckSounds) {
        // 0:q, 1:u, 2:a, 3:c 상태의 오리 수
        int[] counts = new int[4];
        // 현재 울고 있는 오리 수
        int currentDucks = 0;
        // 동시에 울었던 오리의 최대 수
        int maxDucks = 0;
        char[] sounds = duckSounds.toCharArray();

        for (char sound : sounds) {
            switch (sound) {
                case 'q': {
                    counts[0]++;
                    currentDucks++;
                    maxDucks = Math.max(maxDucks, currentDucks);
                    break;
                }
                case 'u': {
                    // 'q' 없이 'u' 소리가 남
                    if (counts[0] == 0)
                        return -1;
                    counts[0]--;
                    counts[1]++;
                    break;
                }
                case 'a': {
                    // 'u' 없이 'a' 소리가 남
                    if (counts[1] == 0)
                        return -1;
                    counts[1]--;
                    counts[2]++;
                    break;
                }
                case 'c': {
                    // 'a' 없이 'c' 소리가 남
                    if (counts[2] == 0)
                        return -1;
                    counts[2]--;
                    counts[3]++;
                    break;
                }
                case 'k': {
                    // 'c' 없이 'k' 소리가 남
                    if (counts[3] == 0)
                        return -1;
                    counts[3]--;
                    // 오리 한 마리가 울음 완료
                    currentDucks--;
                    break;
                }
                default: {
                    return -1; // 'q', 'u', 'a', 'c', 'k' 외의 문자 (문제 조건에 따라)
                }
            }
        }

        // 모든 소리를 처리한 후, 울음이 끝나지 않은 오리가 있는지 확인
        if (currentDucks != 0) {
            return -1;
        }
        // counts 배열에 남은 오리가 있는지 추가 확인 (currentDucks가 0이면 이것도 0이어야 함)
        for (int count : counts) {
            if (count != 0)
                return -1;
        }

        return maxDucks == 0 ? -1 : maxDucks;

    }

}
