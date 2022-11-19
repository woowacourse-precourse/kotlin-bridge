package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private lateinit var bridge: Bridge
    private val userStep = mutableListOf<Pair<String, Boolean>>()
    private var retryCount = 1
    private val inputView = InputView()
    private val outputView = OutputView()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun move(step: String): Boolean {
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
        outputView.printFormattedMsg(OutputView.INPUT_BRIDGE_SIZE)
        val size = inputView.readBridgeSize()
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridgeSteps = bridgeMaker.makeBridge(size)
        bridge = Bridge(bridgeSteps)
    }

    private fun processMoveResult(status: Boolean): Boolean {
        if (!status) {
            return processRetryIO()
        } else if (bridge.getBridgeDone(userStep.size)) {
            outputView.printResult(userStep, retryCount)
            return false
        }
        return true
    }

    private fun processMoveIO(): Boolean {
        outputView.printFormattedMsg(OutputView.INPUT_STEP_SIDE)
        val moving = inputView.readMoving()
        val status = move(moving)
        outputView.printMap(userStep)
        return processMoveResult(status)
    }

    private fun processRetryIO(): Boolean {
        outputView.printFormattedMsg(OutputView.INPUT_RETRY)
        val gameCommand = inputView.readGameCommand()
        if (gameCommand == "R") {
            retryCount += 1
            retry()
            return true
        } else if (gameCommand == "Q") {
            outputView.printResult(userStep, retryCount)
            return false
        }
        return true
    }

    fun gameLoop() {
        retryCount = 1
        outputView.printFormattedMsg(OutputView.START)
        processBridgeSizeIO()
        while (true) {
            if (!processMoveIO())
                break
        }
    }
}
