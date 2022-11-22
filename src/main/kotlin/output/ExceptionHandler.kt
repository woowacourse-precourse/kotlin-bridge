package output

import bridge.InputView
import camp.nextstep.edu.missionutils.Console

object ExceptionHandler {

    fun rangeException(input: Any): Boolean {
        if (input in 3..20) {
            return true
        }
        return false
    }

    fun specificAlphabetUD(input: String): Boolean {
        if (input == "U" || input == "D") {
            return true
        }
        return false
    }

    fun specificAlphabetRQ(input: String): Boolean {
        if (input == "R" || input == "Q") {
            return true
        }
        return false
    }

    fun isInt(): Int {
        val bridgeSize = try {
            Console.readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println(ErrorMessage.ONLY_NUMBER.errorMessage)
            InputView().readBridgeSize()
        }
        return bridgeSize
    }
}