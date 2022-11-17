package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: Bridge) {
    private val userStep = mutableListOf<Pair<BridgeStep, Boolean>>()
    private val inputView = InputView()
    private val outputView = OutputView()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun move(step: BridgeStep): Boolean {
        val status = bridge.getCurrentStepStatus(step, userStep.size)

        userStep.add(Pair(step, status))

        return status
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userStep.clear()
    }

    private fun processBridgeSizeIO() {

    }

    private fun processMoveIO(): Boolean {
        val moving = inputView.readMoving()
        val step = if (moving == "U") BridgeStep.UP else BridgeStep.DOWN
        val status = move(step)
        outputView.printMap()
        if (!status)
            return processRetryIO()
        else if (bridge.getBridgeDone(userStep.size))
            return processRetryIO()
        return true
    }

    private fun processRetryIO(): Boolean {
        val gameCommand = inputView.readGameCommand()
        return if (gameCommand == "R") {
            retry()
            true
        } else {
            outputView.printResult()
            false
        }
    }

    fun gameLoop() {
        while (true) {
            processBridgeSizeIO()
            if (!processMoveIO())
                break
        }
    }
}
