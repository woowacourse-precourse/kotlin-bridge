package bridge

class BridgeGameManager {
    private val output = OutputView()
    var tryingCount = 1
    private var position = 0 // user의 현재 위치

    fun calculateIsMovable(bridgeMap: List<String>, moving: String): Boolean {
        val isMovable = bridgeMap[position] == moving
        output.printMap(bridgeMap, position, isMovable)
        position++

        return isMovable
    }

    fun gameOver(bridgeMap: List<String>, isSuccess: Boolean) {
        output.printResult()
        output.printMap(bridgeMap, position - 1, isSuccess)
        output.printTryingCount(isSuccess, tryingCount)
    }

    fun retryInitial() {
        this.tryingCount++
        this.position = 0
    }

    fun calculateIsArrived(bridgeSize: Int): Boolean {
        return position == bridgeSize
    }
}