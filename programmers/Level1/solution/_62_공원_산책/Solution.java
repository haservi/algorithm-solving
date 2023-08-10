package programmers.Level1.solution._62_공원_산책;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[] park = { "SOO", "OOO", "OOO" };
        String[] routes = { "E 2", "S 2", "W 1" };
        int[] expectedResult = { 2, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(park, routes);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        char[][] map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                startY = i;
                startX = park[i].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] routeSplit = route.split(" ");
            String direction = routeSplit[0];
            int distance = Integer.parseInt(routeSplit[1]);

            int moveX = startX;
            int moveY = startY;

            for (int i = 1; i <= distance; i++) {
                switch (direction) {
                    case "E":
                        moveX++;
                        break;
                    case "W":
                        moveX--;
                        break;
                    case "S":
                        moveY++;
                        break;
                    case "N":
                        moveY--;
                        break;
                }
            
                if (moveX >= 0 && moveY >= 0 && moveY < map.length && moveX < map[0].length) {
                    if (map[moveY][moveX] == 'X') {
                        break;
                    }
                    if (i == distance) {
                        startX = moveX;
                        startY = moveY;
                    }
                }
            }
        }

        int[] answer = { startY, startX };
        return answer;
    }
}
