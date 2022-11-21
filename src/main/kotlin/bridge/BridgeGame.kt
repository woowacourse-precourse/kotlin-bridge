package bridge

import bridge.InputView.Companion.RETRY_COMMAND

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
        outputView.printResult(result)
    }

    fun startCycle() {
        result.increaseTryCount()
        if (repeatMoving(bridge.getBridgeSize())) {
            return
        } else {
            if (retry()) {
                startCycle()
            }
            return
        }
    }

    fun repeatMoving(bridgeSize: Int): Boolean {
        for (pos in 0 until bridgeSize) {
            val playerMove = inputView.readMoving()
            val isCrossable = move(pos, playerMove)
            outputView.printMap(result)
            if (!isCrossable) return false
        }
        result.setSuccess()
        return true
    }

    fun move(position: Int, playerMove: String): Boolean {
        while (true) {
            try {
                val isCrossable = bridge.isCrossable(position, playerMove)
                result.addResult(playerMove, isCrossable)
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
                if (gameCommand == RETRY_COMMAND) {
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
