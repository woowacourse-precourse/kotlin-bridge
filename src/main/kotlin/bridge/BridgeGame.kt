package bridge

class BridgeGame {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val result: Result = Result()
    private var bridge: Bridge

    init {
        outputView.printStartMessage()
        val bridgeSize = getBridgeSize()
        bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize))
    }

    private fun getBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun start() {
        startCycle()
        outputView.printResult(result, result.tryCount)
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
