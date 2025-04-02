package baekjoon.problem._019_기차가_어둠을_헤치고_은하수를;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15787
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int trainCount = Integer.parseInt(st.nextToken());
        boolean[][] trains = new boolean[trainCount][20];
        int orderCount = Integer.parseInt(st.nextToken());
        String[] orders = new String[orderCount];
        for (int i = 0; i < orderCount; i++) {
            orders[i] = br.readLine();
        }

        int result = solution(trains, orders);
        System.out.println(result);
    }

    private static int solution(boolean[][] trains, String[] orders) {

        for (String order : orders) {
            String[] o = order.split(" ");
            int trainIndex = Integer.parseInt(o[1]) - 1;
            switch (o[0]) {
                case "1":
                    // 1 i x : i번째 기차에 x번째 좌석에 사람을 태우기
                    trains[trainIndex][Integer.parseInt(o[2]) - 1] = true;
                    break;
                case "2":
                    // 2 i x : i번째 기차에 x번째 좌석에 사람은 하차
                    trains[trainIndex][Integer.parseInt(o[2]) - 1] = false;
                    break;
                case "3":
                    // 3 i : i번째 기차 승객 모두 뒤로 이동 20번째는 하차
                    for (int i = 19; i > 0; i--) {
                        trains[trainIndex][i] = trains[trainIndex][i - 1];
                    }
                    trains[trainIndex][0] = false;
                    break;
                case "4":
                    // 4 i : i번째 승객 모두 한칸 앞으로 1번째는 하차
                    for (int i = 0; i < 19; i++) {
                        trains[trainIndex][i] = trains[trainIndex][i + 1];
                    }
                    trains[trainIndex][19] = false;
                    break;
                default:
                    break;
            }
        }

        Set<String> uniqueTrains = new HashSet<>();
        for (boolean[] train : trains) {
            StringBuilder sb = new StringBuilder();
            for (boolean seat : train) {
                sb.append(seat ? '1' : '0');
            }
            uniqueTrains.add(sb.toString());
        }

        return uniqueTrains.size();
    }

}
