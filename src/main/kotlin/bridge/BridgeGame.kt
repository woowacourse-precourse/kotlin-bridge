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
        updateGameProgress(moving)
        moveCount++
    }

    fun retry() {}


    fun getBridgeSize(): Int { return bridgeSize }

    fun getTryCount(): Int { return tryCount }

    fun getMoveCount(): Int { return moveCount }

    fun setBridgeSize(inputLength: Int) { bridgeSize = inputLength }

    fun setBridge(bridgeMaker: BridgeMaker) { bridge = bridgeMaker.makeBridge(bridgeSize) }

    fun isCorrect(moving: String): Boolean { return bridge[moveCount] == moving }

    private fun updateGameProgress(moving: String) {
        if (moving == MOVING_UP) {
            gameProgress[0].add(if (isCorrect(moving)) "O" else "X")
            gameProgress[1].add(" ")
        }
        else if (moving == MOVING_DOWN) {
            gameProgress[0].add(" ")
            gameProgress[1].add(if (isCorrect(moving)) "O" else "X")
        }
    }

    companion object {
        const val MOVING_DOWN = "D"
        const val MOVING_UP = "U"
    }
}
