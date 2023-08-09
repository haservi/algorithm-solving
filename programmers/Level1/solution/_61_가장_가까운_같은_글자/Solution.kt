package programmers.Level1.solution._58_달리기_경주

fun main() {
    val s = "banana"
    val expectedResurt = intArrayOf(-1, -1, -1, 2, 2, 2)

    val result = solution(s)

    if (expectedResurt.contentEquals(result)) {
        println("Pass")
    } else {
        println("Fail")
    }
}

fun solution(s: String): IntArray {
    val answer = IntArray(s.length)
    val keyMap = HashMap<Char, Int>()

    for (i in s.indices) {
        if (!keyMap.containsKey(s[i])) {
            answer[i] = -1
        } else {
            answer[i] = i - keyMap[s[i]]!!
        }
        keyMap[s[i]] = i
    }
    return answer
}