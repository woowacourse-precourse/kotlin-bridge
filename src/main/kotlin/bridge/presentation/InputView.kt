package bridge.presentation

import bridge.util.validator.Validator
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val size = Console.readLine()
        Validator.validateIsNumber(size)
        Validator.validateRange(size.toInt())

        return size.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readDirection(): String {
        val direction = Console.readLine()
        Validator.validateDirection(direction)

        return direction
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val retry = Console.readLine()
        Validator.validateRetrial(retry)

        return retry
    }
}
