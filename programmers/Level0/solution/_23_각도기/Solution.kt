package programmers.Level0.solution._23_각도기

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120829?language=kotlin
*/
fun main() {
    val angle: Int = 180

    val result = solution(angle)
    print("result: " + result)
}

fun solution(angle: Int): Int {
    if (0 < angle && angle < 90) return 1
    if (angle == 90) return 2
    if (90 < angle && angle < 180) return 3
    if (angle == 180) return 4
    return 0
}
