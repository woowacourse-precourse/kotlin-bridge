package exception

import util.Error
import java.util.NoSuchElementException

class ExceptionCheck {

    fun checkValidMoveLetterInput(userInput: String): String {
        when {
            !isLetter(userInput) -> {
                println(Error.MOVE_INPUT_TYPE_ERROR.message)
                throw IllegalArgumentException()
            }
            !checkValidLetter(userInput) -> {
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

    private fun checkValidLetter(userInput: String): Boolean {
        for (i in userInput.indices) {
            if (userInput[i] == 'U' || userInput[i] == 'D') {
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
