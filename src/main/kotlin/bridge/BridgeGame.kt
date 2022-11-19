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

    fun move() {
        moveCount++
        // updateGameProgress()
    }

    fun retry() {}

    companion object {
        const val MOVING_DOWN = "D"
        const val MOVING_UP = "U"
    }
}
