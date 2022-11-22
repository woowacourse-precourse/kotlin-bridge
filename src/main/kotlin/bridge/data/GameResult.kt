package bridge.data

class GameResult {
    var attempt = 1
    var result = "실패"
    fun getGameResult(): Pair<String, Int> {
        return result to attempt
    }

    fun succeed() {
        result = "성공"
    }

    fun increase() {
        attempt++
    }
}