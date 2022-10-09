package programmers.Level0.solution._26_점의_위치_구하기

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120841
 */
fun main() {
    val dot = intArrayOf(2, 4)
    var result = solution(dot)
    print("result: " + result)
}

fun solution(dot: IntArray): Int {
    if (0 < dot[0] && 0 < dot[1]) return 1
    if (dot[0] < 0 && 0 < dot[1]) return 2
    if (dot[0] < 0 && dot[1] < 0) return 3
    if (0 < dot[0] && dot[1] < 0) return 4
    return 0
}

fun diffSolution(dot: IntArray): Int = when {
    dot[0] > 0 && dot[1] > 0 -> 1
    dot[0] < 0 && dot[1] > 0 -> 2
    dot[0] < 0 && dot[1] < 0 -> 3
    else -> 4
}
