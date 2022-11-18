package bridge

import java.util.regex.Pattern

object Regex {

    fun checkItsNull(userInput: String) {
        if(userInput.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    fun checkItsAllNumber(userInput: String) {
        if (!Pattern.matches("^[0-9]*$", userInput)) {
            throw IllegalArgumentException()
        }
    }
}