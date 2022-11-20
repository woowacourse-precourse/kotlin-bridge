package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val realBridges: List<String>) {
    private val bridges = mutableListOf<String>()
    private var curStep: Int = 0
    private var success: Boolean = false
    private var tryCount: Int = 1

    init {
        for (i in realBridges.indices) {
            bridges.add("U")
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(curMove: String): BridgeMoveResult {
        bridges[curStep] = curMove
        if (bridges[curStep] == realBridges[curStep] && curStep + 1 == realBridges.size) return BridgeMoveResult.MOVE_END
        if (bridges[curStep] == realBridges[curStep]) {
            curStep++
            return BridgeMoveResult.MOVE_SUCCESS
        }
        return BridgeMoveResult.MOVE_FAILED
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    enum class BridgeMoveResult {
        MOVE_SUCCESS, MOVE_FAILED, MOVE_END
    }
}
