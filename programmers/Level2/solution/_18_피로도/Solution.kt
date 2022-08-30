/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=kotlin
 */
fun main() {
    var k = 80
    val dungeons: Array<IntArray> = arrayOf(
        intArrayOf(80, 20),
        intArrayOf(50, 40),
        intArrayOf(30, 10)
    )

    var result = solution(k, dungeons)
    print("result: " + result)
}

var visited = BooleanArray(0)
var answer = 0

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    visited = BooleanArray(dungeons.size)
    dfs(k, dungeons, 0)
    return answer
}

fun dfs(k: Int, dungeons: Array<IntArray>, depth: Int) {
    for (i in dungeons.indices) {
        if (dungeons[i][0] <= k && !visited[i]) {
            visited[i] = true
            dfs(k - dungeons[i][1], dungeons, depth + 1)
            visited[i] = false
        }
    }
    answer = Math.max(answer, depth)
}
