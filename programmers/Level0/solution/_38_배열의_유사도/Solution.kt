package programmers.Level0.solution._38_배열의_유사도

/*
https://school.programmers.co.kr/learn/courses/30/lessons/120903
*/
fun main() {
    val s1 = arrayOf("a", "b", "c")
    val s2 = arrayOf("com", "b", "d", "p", "c")
    var result = solution(s1, s2)
    print("result: $result")
}

fun solution(s1: Array<String>, s2: Array<String>): Int {
    var answer: Int = 0
    for (i in s1.indices) {
        for (j in s2.indices) {
            if (s1[i].equals(s2[j])) {
                answer++
                break
            }
        }
    }
    return answer
}

fun diffSolution(s1: Array<String>, s2: Array<String>): Int = s1.count { s2.contains(it) }
