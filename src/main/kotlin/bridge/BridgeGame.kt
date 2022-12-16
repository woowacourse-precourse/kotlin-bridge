package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val realBridges: List<String>) {
    private val bridges = mutableListOf<String>()
    var curStep: Int = 0
        private set  // setter만 private로 막아놓기.
    var isSuccess: Boolean = false
        private set
    var tryCount: Int = 1
        private set

    init {
        for (i in realBridges.indices) {
            bridges.add("U") // 내가 건널 다리의 값 초기화.
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
        curStep++
        if (bridges[curStep - 1] == realBridges[curStep - 1]) {
            return isMoveEnd()
        }
        return BridgeMoveResult.MOVE_FAILED
    }

    private fun isMoveEnd(): BridgeMoveResult =
        if (curStep == realBridges.size) {
            isSuccess = true
            BridgeMoveResult.MOVE_END
        } else
            BridgeMoveResult.MOVE_SUCCESS


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        isSuccess = false
        tryCount++
        curStep = 0
    }

    fun realBridges(): List<String> = realBridges.toList()
    fun gameBridges(): List<String> = bridges.toList()

    enum class BridgeMoveResult {
        MOVE_SUCCESS, MOVE_FAILED, MOVE_END
    }
}
