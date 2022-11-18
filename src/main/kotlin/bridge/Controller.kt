package bridge

class Controller {

    private lateinit var bridgeGame: BridgeGame

    fun run() {
        bridgeGame = BridgeGame(inputBridgeSize())
        startGame()
    }

    fun startGame(){
        val moveDirection = inputMoveDirection()
        val movePossible = bridgeGame.getInputMovePossible(moveDirection)
        bridgeGame.move(moveDirection)
        OutputView().printMap(bridgeGame.getBridge())
        if(bridgeGame.getGameResult()) {
            return endGame()
        }
        if(movePossible) {
            return startGame()
        }
        return restartGame()
    }

    fun restartGame() {
        val input = inputRestartValue()
        when(input) {
            "Q" -> return endGame()
            "R" -> {
                bridgeGame.retry()
                return startGame()
            }
        }

    }

    fun endGame() {
        OutputView().printResult(bridgeGame.getBridge())
        OutputView().printSuccessFail(bridgeGame.getGameResult())
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
}