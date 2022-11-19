package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridgeSize: Int) {
    private var retryCounter = 1
    private var isContinue = true
    private val upBridge: MutableList<String> = MutableList(this.bridgeSize) { INIT_MOVE }
    private val downBridge: MutableList<String> = MutableList(this.bridgeSize) { INIT_MOVE }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: List<String>, move: String, position: Int) {
        when (bridge[position] == move) {
            true -> this.moveNextBridge(move, position, CORRECT_MOVE)
            false -> {
                this.moveNextBridge(move, position, WRONG_MOVE)
                this.isContinue = false
            }
        }
    }

    private fun moveNextBridge(move: String, position: Int, operation: String) {
        when (move) {
            InputView.COMMAND_UP -> this.upBridge[position] = operation
            InputView.COMMAND_DOWN -> this.downBridge[position] = operation
        }
    }

    fun getUpBridge() = this.upBridge

    fun getDownBridge() = this.downBridge

    fun getRetryCounter() = this.retryCounter

    fun getIsContinue() = this.isContinue

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        this.retryCounter++
        for (i in 0 until this.bridgeSize) {
            this.upBridge[i] = INIT_MOVE
            this.downBridge[i] = INIT_MOVE
        }
        this.isContinue = true
    }

    companion object {
        const val CORRECT_MOVE = "O"
        const val WRONG_MOVE = "X"
        const val INIT_MOVE = " "
    }
}
