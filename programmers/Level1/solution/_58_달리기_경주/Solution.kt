package programmers.Level1.solution._58_달리기_경주

fun main() {
    val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    val callings = arrayOf("kai", "kai", "mine", "mine")
    val expectResult = arrayOf("mumu", "kai", "mine", "soe", "poe")

    val result = solution(players, callings)

    if (result.contentEquals(expectResult)) {
        println("Test Passed")
    } else {
        println("Test Failed")
    }
}

fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    val playerIndexMap = HashMap<String, Int>()

    for (i in players.indices) {
        playerIndexMap[players[i]] = i
    }

    for (calling in callings) {
        if (playerIndexMap.containsKey(calling)) {
            val playerIndex = playerIndexMap[calling]!!

            if (playerIndex > 0) {
                val temp = players[playerIndex - 1]
                players[playerIndex - 1] = players[playerIndex]
                players[playerIndex] = temp
                playerIndexMap[players[playerIndex - 1]] = playerIndex - 1
                playerIndexMap[players[playerIndex]] = playerIndex
            }
        }
    }

    return players
}
