package bridge
import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val input: Int
        try {
            input = Console.readLine().toInt()
            if (input !in 3..20) {
                throw IllegalArgumentException()
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }

       return input
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val input = Console.readLine()
        if (input.length != 1 || input !in listOf("U", "D", "u", "d")) {
            throw IllegalArgumentException()
        }
        return input.uppercase()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input = Console.readLine()
        if (input.length != 1 || input !in listOf("R", "Q", "r", "q")) {
            throw IllegalArgumentException()
        }
        return input.uppercase()
    }
}
