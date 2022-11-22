package bridge

class BridgeGame {
    fun move(route: String, moving: String): String {
        if (route == moving) return "O"
        return "X"
    }

    fun retry(bridge: List<String>, tryCount: Int) {
        val movingResult = proceedGame(bridge)
        finishGame(bridge, movingResult, tryCount)
    }
}