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

}
