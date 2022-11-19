package bridge.validator

object BridgeGameValidator {

    fun validateMoveOutput(isMatched: Boolean, round: Int): Int {
        var currentRound = round
        if (isMatched) currentRound++
        if (!isMatched) currentRound
        return currentRound
    }
}