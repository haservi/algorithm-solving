package baekjoon.problem._023_ZOAC_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20436
 */
public class Main {

    // --- 프로그램 실행을 위한 main 함수 ---
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char initialLeftChar = st.nextToken().charAt(0);
            char initialRightChar = st.nextToken().charAt(0);
            String targetString = br.readLine();

            // solution 함수 호출하여 결과 계산
            int result = solution(initialLeftChar, initialRightChar, targetString);

            // 결과 출력
            System.out.println(result);
        }
    }

    static class Point {
        int row;
        int column;

        Point(int r, int c) {
            this.row = r;
            this.column = c;
        }
    }

    // 각 문자의 위치를 저장할 Map
    static Map<Character, Point> keyMap = new HashMap<>();
    // 왼손 담당 키
    static Set<Character> leftKeys = new HashSet<>();

    public static int solution(char initialLeftChar, char initialRightChar, String targetString) {
        // 키보드 정보 초기화
        setupKeyboard();

        Point leftPos = keyMap.get(initialLeftChar);
        Point rightPos = keyMap.get(initialRightChar);

        // 총 걸린 시간 계산
        int totalTime = 0;

        // 목표 문자열을 한 글자씩 처리
        for (int i = 0; i < targetString.length(); i++) {
            char targetChar = targetString.charAt(i);
            Point targetPos = keyMap.get(targetChar);

            // 왼손으로 쳐야 하는 경우
            if (leftKeys.contains(targetChar)) {
                // 이동 시간 계산
                int moveTime = calculateDistance(leftPos, targetPos);
                // 이동 시간 + 누르는 시간(1)
                totalTime += moveTime + 1;
                // 왼손 위치 업데이트
                leftPos = targetPos;
            }
            // 오른손으로 쳐야 하는 경우
            else {
                // 이동 시간 계산
                int moveTime = calculateDistance(rightPos, targetPos);
                // 이동 시간 + 누르는 시간(1)
                totalTime += moveTime + 1;
                // 오른손 위치 업데이트
                rightPos = targetPos;
            }
        }

        return totalTime;
    }

    /**
     * 키보드 레이아웃 및 왼손/오른손 담당 구역 설정
     * keyMap과 leftKeys를 초기화
     */
    static void setupKeyboard() {
        // 키보드 각 줄 정의
        String[] rows = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        keyMap.clear();
        leftKeys.clear();

        // 각 문자의 좌표(행, 열)를 keyMap에 저장
        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows[r].length(); c++) {
                keyMap.put(rows[r].charAt(c), new Point(r, c));
            }
        }

        // 왼손 담당 키들을 Set에 추가
        leftKeys.addAll(Arrays.asList('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'));
    }

    /**
     * 두 점 사이의 거리 계산
     */
    static int calculateDistance(Point p1, Point p2) {
        return Math.abs(p1.row - p2.row) + Math.abs(p1.column - p2.column);
    }
}
