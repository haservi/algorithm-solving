package programmers.Level0.solution._28_배열_뒤집기

import java.util.*

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120821
 */
fun main() {
    val num_list = intArrayOf(1, 2, 4, 5)
    var result = solution(num_list)
    print("result: " + Arrays.toString(result))
}

fun solution(num_list: IntArray): IntArray {
    var answer: IntArray = IntArray(num_list.size)
    var index = num_list.size
    for (num in num_list) {
        answer[--index] = num
    }
    return answer
}

fun diffSolution(numList: IntArray) = numList.reversedArray()
