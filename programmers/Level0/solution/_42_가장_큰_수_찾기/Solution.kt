package programmers.Level0.solution._42_가장_큰_수_찾기

fun main() {
    val array = intArrayOf(1, 8, 3)
    var result = solution(array)
    print("result: " + result.contentToString())

}

fun solution(array: IntArray): IntArray {
    var answer: IntArray = IntArray(2)
    for ((index, value) in array.withIndex()) {
        if (answer[0] < value) {
            answer[0] = value
            answer[1] = index
        }
    }
    return answer
}