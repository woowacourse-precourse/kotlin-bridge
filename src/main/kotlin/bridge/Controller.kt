package bridge

class Controller {

    private lateinit var bridgeGame: BridgeGame
    private lateinit var bridgeResult: BridgeResult

    fun run() {
        bridgeGame = BridgeGame(inputBridgeSize())
        startGame()
    }

    fun startGame(){
        OutputView().pringGameStartMessage()
        val moveDirection = inputMoveDirection()
        bridgeResult = bridgeGame.move(moveDirection)
        OutputView().printMap(bridgeResult)
        if(bridgeResult.getGameResult().isSuccess()) return endGame()
        if(bridgeResult.getMovePossible().isPossible()) return startGame()
        return restartGame()
    }

    fun restartGame() {
        val input = inputRestartValue()
        when(input) {
            GAME_QUIT_VALUE -> return endGame()
            GAME_RESTART_VALUE -> {
                bridgeGame.retry()
                return startGame()
            }
        }
    }

    fun endGame() {
        OutputView().printResult(bridgeResult)
        OutputView().printSuccessFail(bridgeResult)
        OutputView().printGameCount(bridgeGame.getGameCount())
    }

    fun inputBridgeSize() : Int {
        OutputView().printInputBridgeSizeMessage()
        return getBridgeSize(InputView().readBridgeSize())
    }

    fun getBridgeSize(input : String?) : Int {
        try {
            Validator().checkBridgeLength(input)
            return input!!.toInt()
        } catch(e : IllegalArgumentException) {
            OutputView().printError(e)
            return inputBridgeSize()
        }
    }

    fun inputMoveDirection() : String {
        OutputView().printInputMoveDirectionMessage()
        return getMoveDirection(InputView().readMoving())
    }

    fun getMoveDirection(input : String?) : String {
        try {
            Validator().checkMoveDirection(input)
            return input!!
        } catch(e : IllegalArgumentException) {
            OutputView().printError(e)
            return inputMoveDirection()
        }
    }

    fun inputRestartValue() : String {
        OutputView().printInputRestartMessage()
        return getRestartValue(InputView().readGameCommand())
    }

    fun getRestartValue(input: String?) : String {
        try {
            Validator().checkRestartValue(input)
            return input!!
        } catch(e : IllegalArgumentException) {
            return inputRestartValue()
        }
    }

    companion object {
        const val GAME_RESTART_VALUE = "R"
        const val GAME_QUIT_VALUE = "Q"
    }
}