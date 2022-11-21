package bridge.view.validator

object BridgeGameValidator {

    fun validateMoveOutput(isMatched: Boolean): Int {
        var currentRound = 0
        if (isMatched) currentRound++
        return currentRound
    }
}