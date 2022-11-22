package bridge

class BridgeGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridge: Bridge
) {

    private val result: Result = Result()

    fun start() {
        startCycle()
        outputView.printResult(result)
    }

    private fun startCycle() {
        result.increaseTryCount()
        if (repeatMoving(bridge.getBridgeSize())) {
            return
        } else {
            val gameCommand = getGameCommand()
            if (retry(gameCommand)) {
                startCycle()
            }
            return
        }
    }

    private fun repeatMoving(bridgeSize: Int): Boolean {
        for (pos in 0 until bridgeSize) {
            val playerMove = getPlayerMove()
            val isCrossable = move(pos, playerMove)
            outputView.printMap(result)
            if (!isCrossable) return false
        }
        result.setSuccess()
        return true
    }

    private fun getPlayerMove(): String {
        while (true) {
            try {
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun move(position: Int, playerMove: String): Boolean {
        val isCrossable = bridge.isCrossable(position, playerMove)
        result.addResult(playerMove, isCrossable)
        return isCrossable
    }

    private fun getGameCommand(): String {
        while (true) {
            try {
                return inputView.readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun retry(gameCommand: String): Boolean {
        if (gameCommand == GameCommand.RETRY.getCommand()) {
            result.resetResult()
            return true
        }
        return false
    }

    fun getResult(): Result {
        return result
    }
}
