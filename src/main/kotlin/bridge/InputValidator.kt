package bridge

import bridge.sentence.ErrorSentence

object InputValidator {
    private const val BRIDGE_LENGTH_MIN = 3
    private const val BRIDGE_LENGTH_MAX = 20

    fun validateBridgeLength(input: String) {
        if(input.any { !it.isDigit() } || input.toInt() !in BRIDGE_LENGTH_MIN..BRIDGE_LENGTH_MAX)
            throw IllegalArgumentException(ErrorSentence.BRIDGE_LENGTH.sentence())
    }
}