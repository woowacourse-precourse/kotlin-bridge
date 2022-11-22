package output

import bridge.InputView
import camp.nextstep.edu.missionutils.Console
import org.w3c.dom.ranges.RangeException

object ExceptionHandler {
    fun rangeException(input: Int): Boolean {
        try {
            if (input < 3 || input > 20) {
                throw RangeException(0, "")
            }
        } catch (e: RangeException) {
            println("$e\n" + ErrorMessage.RANGE.errorMessage)
            return false
        }
        return true
    }

    fun specificAlphabetUD(input: String): Boolean {
        try {
            if (input != "U" && input != "D") {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("$e\n" + ErrorMessage.UD.errorMessage)
            return false
        }
        return true
    }

    fun specificAlphabetRQ(input: String): Boolean {
        try {
            if (input != "R" && input != "Q") {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("$e\n" + ErrorMessage.RQ.errorMessage)
            return false
        }
        return true
    }

    fun isInt(): Int {
        val bridgeSize = try {
            Console.readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("$e\n" + ErrorMessage.ONLY_NUMBER.errorMessage)
            InputView().readBridgeSize()
        }
        return bridgeSize
    }
}