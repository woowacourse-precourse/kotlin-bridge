package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val gameProgress: List<MutableList<String>> = List(2) { mutableListOf() }
    private var tryCount: Int = 1
    private var moveCount: Int = 0
    private var bridgeSize: Int = 0
    private var bridge: List<String> = listOf()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {
        moveCount++
        // updateGameProgress()
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    companion object {
        const val MOVING_DOWN = "D"
        const val MOVING_UP = "U"
    }
}
