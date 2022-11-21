package exception

import util.Error
import java.util.NoSuchElementException

class ExceptionCheck {


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
