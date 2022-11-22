package bridge

import bridge.sentence.ErrorSentence

object InputValidator {
    fun validateDigitNumber(input: String) {
        if (input.any { !it.isDigit() })
            throw IllegalArgumentException(ErrorSentence.BRIDGE_LENGTH.sentence())
    }
}