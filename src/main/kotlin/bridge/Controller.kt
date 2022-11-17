package bridge

class Controller {

    fun start() {

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
}