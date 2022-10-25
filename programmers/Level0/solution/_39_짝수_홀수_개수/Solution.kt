package programmers.Level0.solution._39_짝수_홀수_개수

import java.util.Arrays

fun main() {
    val num_list = intArrayOf(1, 2, 3, 4, 5)
    var result = solution(num_list)
    print("result: " + Arrays.toString(result))
}

fun solution(num_list: IntArray): IntArray {
    var answer: IntArray = IntArray(2)
    num_list.forEach {
        if (it % 2 == 0) answer[0]++ else answer[1]++
    }
    return answer
}
