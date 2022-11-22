package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val state: BridgeState,
) {

    init {
        state.inputBridgeLengthPart()
    }

    fun play() {
        val bridge = initialBridge()
        var isAlive: Boolean
        while (true) {
            isAlive = move(bridge)
            val isRetry = retry(isAlive)
            if (!isRetry) break
        }
        state.gameFinish(bridge, isAlive)
    }

    private fun initialBridge() =
        BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(state.bridgeLength)

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun move(bridge: List<String>): Boolean {
        for (cnt in 1..state.bridgeLength) {
            state.bridgeMovePart(bridge)
            if (!state.isUserLive(bridge)) return false
        }
        return true
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(isAlive: Boolean): Boolean {
        if (!isAlive) {
            return state.gameRetry()
        }
        return false
    }
}
