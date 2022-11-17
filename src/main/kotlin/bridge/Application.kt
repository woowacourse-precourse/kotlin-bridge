package bridge

fun main() {
    // TODO: 프로그램 구현
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
