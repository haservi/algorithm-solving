/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=kotlin
 */
fun main() {
    var survey: Array<String> = arrayOf("AN", "CF", "MJ", "RT", "NA")
    var choices: IntArray = intArrayOf(5, 3, 2, 7, 5)

    var result = solution(survey, choices)
    print(result)
}

fun solution(survey: Array<String>, choices: IntArray): String {
    var surveyType: Array<CharArray> =
        arrayOf(
            charArrayOf('R', 'T'),
            charArrayOf('C', 'F'),
            charArrayOf('J', 'M'),
            charArrayOf('A', 'N')
        )

    var userMap: HashMap<Char, Int> = HashMap()
    for (i in survey.indices) {
        var choice: Int = choices[i]
        if (choice < 4) {
            var user: Char = survey[i].get(0)
            userMap.put(user, userMap.getOrDefault(user, 0) + 4 - choice)
        } else if (4 < choice) {
            var user: Char = survey[i].get(1)
            userMap.put(user, userMap.getOrDefault(user, 0) + choice - 4)
        }
    }

    var result: StringBuilder = StringBuilder()
    (surveyType).forEach { type ->
        var leftScore: Int = userMap.getOrDefault(type[0], 0)
        var rightScore: Int = userMap.getOrDefault(type[1], 0)
        if (rightScore <= leftScore) {
            result.append(type[0])
        } else {
            result.append(type[1])
        }
    }
    return result.toString()
}
