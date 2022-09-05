package programmers.Level3.solution._10_여행경로

import java.util.*

fun main() {
    var tickets: Array<Array<String>> =
            arrayOf(
                    arrayOf("ICN", "SFO"),
                    arrayOf("ICN", "ATL"),
                    arrayOf("SFO", "ATL"),
                    arrayOf("ATL", "ICN"),
                    arrayOf("ATL", "SFO")
            )
    var result: Array<String> = solution(tickets)
    print("result: " + Arrays.toString(result))
}

var START_POINT_ICN: String = "ICN"
var visited: MutableList<Boolean> = mutableListOf()
var routeList: MutableList<String> = mutableListOf()

fun solution(tickets: Array<Array<String>>): Array<String> {
    visited = MutableList(tickets.size) { false }

    var count: Int = 0

    dfs(START_POINT_ICN, START_POINT_ICN, tickets, count)
    return routeList.sorted()[0].split(" ").toTypedArray()
}

fun dfs(start: String, dest: String, tickets: Array<Array<String>>, count: Int) {
    if (count == tickets.size) {
        routeList.add(dest)
        return
    }

    for (i in tickets.indices) {
        if (!visited[i] && tickets[i][0] == start) {
            visited[i] = true
            dfs(tickets[i][1], dest + " " + tickets[i][1], tickets, count + 1)
            visited[i] = false
        }
    }
}
