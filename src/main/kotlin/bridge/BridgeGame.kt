package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private lateinit var result: Result
    private lateinit var bridge: Bridge

    fun start() {
        outputView.printStartMessage()
        val bridgeSize = getBridgeSize()
        bridge = Bridge(BridgeMaker(bridgeRandomNumberGenerator).makeBridge(bridgeSize))
        result = Result()
        startCycle()
        outputView.printResult(result, result.tryCount)
    }

    fun getBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun startCycle() {
        result.increaseTryCount()
        if (isFinished(bridge.getBridgeSize())) {
            return
        } else {
            if (retry()) {
                startCycle()
            }
            return
        }
    }

    fun isFinished(bridgeSize: Int): Boolean {
        for (pos in 0 until bridgeSize) {
            if (!move(pos)) return false
        }
        result.setSuccess()
        return true
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(position: Int): Boolean {
        while (true) {
            try {
                val playerMove = inputView.readMoving()
                val isCrossable = bridge.isCrossable(position, playerMove)
                result.addResult(playerMove, isCrossable)
                outputView.printMap(result.firstRowResult, result.secondRowResult)
                return isCrossable
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(): Boolean {
        while (true) {
            try {
                val gameCommand = inputView.readGameCommand()
                if (gameCommand == "R") {
                    result.resetResult()
                    return true
                }
                return false
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
