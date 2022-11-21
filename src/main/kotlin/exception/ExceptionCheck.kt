package exception

import util.Error
import java.util.NoSuchElementException

class ExceptionCheck {
    fun checkValidBridgeLengthInput(userInput: String): String {
        when {
            !isNumber(userInput) -> {
                println(Error.BRIDGE_LENGTH_INPUT_TYPE_ERROR.message)
                throw IllegalArgumentException()
            }
            !checkValidNumberRange(userInput) -> {
                println(Error.BRIDGE_LENGTH_INPUT_RANGE_ERROR.message)
                throw IllegalArgumentException()
            }
            !checkValidInputNumber(userInput) -> {
                println(Error.INPUT_NUMBER_ERROR.message)
                throw IllegalArgumentException()
            }
            else -> {
                return userInput
            }
        }
    }

    fun checkValidMoveLetterInput(userInput: String): String {
        when {
            !isLetter(userInput) -> {
                println(Error.MOVE_INPUT_TYPE_ERROR.message)
                throw IllegalArgumentException()
            }
            !checkValidMoveLetter(userInput) -> {
                println(Error.MOVE_INPUT_LETTER_ERROR.message)
                throw IllegalArgumentException()
            }
            !checkValidInputNumber(userInput) -> {
                println(Error.INPUT_NUMBER_ERROR.message)
                throw IllegalArgumentException()
            }
            else -> {
                return userInput
            }
        }
    }

    private fun isNumber(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i].isDigit()) {
                return true
            }
        }
        return false
    }

    private fun isLetter(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i].isLetter()) {
                return true
            }
        }
        return false
    }

    private fun checkValidNumberRange(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i].code in 3..20) {
                return true
            }
        }
        return false
    }

    private fun checkValidMoveLetter(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i] == 'U' || userInput[i] == 'D') {
                return true
            }
        }
        return false
    }

    private fun checkValidRetryLetter(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i] == 'R' || userInput[i] == 'Q') {
                return true
            }
        }
        return false
    }

    private fun checkValidInputNumber(userInput: String): Boolean {
        if(userInput.length == 1){
            return true
        }
        return false
    }
}
