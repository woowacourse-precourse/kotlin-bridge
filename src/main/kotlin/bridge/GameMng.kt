package bridge

class GameMng {
    private val game = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()

    private fun processBridgeSizeIO() {
        outputView.printFormattedMsg(OutputView.INPUT_BRIDGE_SIZE)
        val size = inputView.readBridgeSize()
        game.makeBridge(size)
    }

    private fun processMoveResult(): Boolean {
        if (game.hasStepDone()) {
            outputView.printResult(game.getUserStep(), game.getRetryCount())
            return false
        } else if (game.hasFailedLastStep()) {
            return processRetryIO()
        }
        return true
    }

    private fun processMoveIO() {
        outputView.printFormattedMsg(OutputView.INPUT_STEP_SIDE)

        val moving = inputView.readMoving()

        game.move(moving)

        outputView.printMap(game.getUserStep())
    }

    private fun processRetryIO(): Boolean {
        outputView.printFormattedMsg(OutputView.INPUT_RETRY)
        val gameCommand = inputView.readGameCommand()
        if (gameCommand == "R")
            game.retry()
        else if (gameCommand == "Q") {
            outputView.printResult(game.getUserStep(), game.getRetryCount())
            return false
        }
        return true
    }

    fun gameLoop() {
        game.restart()
        outputView.printFormattedMsg(OutputView.START)
        processBridgeSizeIO()
        while (true) {
            processMoveIO()
            if (!processMoveResult())
                break
        }
    }

}