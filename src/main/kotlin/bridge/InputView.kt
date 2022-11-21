package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val validation = ValidationInput()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var size = Console.readLine()

        while (true) {
            try {
                validation.validateSizeValue(size)
                break
            } catch (e: IllegalArgumentException) {
                size = Console.readLine()
            }
        }

        return size.toInt()
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
