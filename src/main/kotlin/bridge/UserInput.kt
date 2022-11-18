package bridge

class UserInput {
    fun userInputMovement() : String = InputView().readMoving()

    fun userInputRetry() : String = InputView().readGameCommand()
}