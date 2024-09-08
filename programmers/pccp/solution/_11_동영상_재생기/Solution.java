package programmers.pccp.solution._11_동영상_재생기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340213?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = { "next", "prev" };
        String expectedResult = "13:00";

        Solution solution = new Solution();
        String result = solution.solution(video_len, pos, op_start, op_end, commands);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSecond = timeToSecond(video_len);
        int opStartSecond = timeToSecond(op_start);
        int opEndSecond = timeToSecond(op_end);
        int currentSecond = timeToSecond(pos);

        for (String command : commands) {
            if (isWithinOperationRange(currentSecond, opStartSecond, opEndSecond)) {
                currentSecond = opEndSecond;
            }

            if (command.equals("next")) {
                currentSecond += 10;
            } else {
                currentSecond = Math.max(0, currentSecond - 10);
            }

            if (isWithinOperationRange(currentSecond, opStartSecond, opEndSecond)) {
                currentSecond = opEndSecond;
            }

            if (videoLenSecond < currentSecond) {
                currentSecond = videoLenSecond;
            }
        }

        return convertToTime(currentSecond);
    }

    private boolean isWithinOperationRange(int current, int start, int end) {
        return start <= current && current <= end;
    }

    private int timeToSecond(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private String convertToTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

}
