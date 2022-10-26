package programmers.Level0.solution._41_특정_문자_제거하기

fun main() {
    val my_string = "aBBBbcd"
    var letter = "b"

    var result = solution(my_string, letter)
    print("result: $result")
}

fun solution(my_string: String, letter: String) = my_string.replace(letter, "")
