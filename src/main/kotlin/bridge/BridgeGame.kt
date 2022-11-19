package bridge

/**
 * 다리 건너기 게임의 상태를 관리하는 클래스
 */
class BridgeGame {
    private val gameProgress: List<MutableList<String>> = List(2) { mutableListOf() }
    private var tryCount: Int = 1
    private var moveCount: Int = 0
    private var bridgeSize: Int = 0
    private var bridge: List<String> = listOf()

    fun move(moving: String) {
        moveCount++
        // updateGameProgress()
    }

    fun retry() {}


    fun getBridgeSize(): Int {
        return bridgeSize
    }

    fun setBridgeSize(inputLength: Int) {
        bridgeSize = inputLength
    }

    fun getTryCount(): Int {
        return tryCount
    }

    fun getMoveCount(): Int {
        return moveCount
    }

    fun setBridge(bridgeMaker: BridgeMaker) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    companion object {
        const val MOVING_DOWN = "D"
        const val MOVING_UP = "U"
    }
}
