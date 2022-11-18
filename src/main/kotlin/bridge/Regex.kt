package bridge

import java.util.regex.Pattern

class Regex(private val userInput: String) {

    fun checkBridgeLengthRegexes() : Boolean {
        return try {
            checkItsNull(userInput)
            checkItsAllNumber(userInput)
            checkBridgeLengthInRange(userInput)
            true
        } catch (e : IllegalArgumentException) {
            false
        }
    }

    private fun checkItsNull(userInput: String) {
        if(userInput.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    private fun checkItsAllNumber(userInput: String) {
        if (!Pattern.matches("^[0-9]*$", userInput)) {
            throw IllegalArgumentException()
        }
    }

    private fun checkBridgeLengthInRange(userInput: String) {
        if(userInput.toInt() !in 3..20) {
            throw IllegalArgumentException()
        }
    }
}