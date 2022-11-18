package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val validator = Validator()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var size: String
        do {
            size = Console.readLine()
            var stop = false
            try {
                stop = validator.isNumber(size) && validator.validateBridgeSize(size)
            } catch (e: IllegalArgumentException) {
                println("다시 입력하쇼잉~!")
            }
        } while (!stop)
        return size.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var move: String
        do {
            move = Console.readLine()
            var stop = false
            try {
                stop = validator.validateUpAndDown(move)
            } catch (e: IllegalArgumentException) {
                println("다시 입력하쇼잉~!")
            }
        } while (!stop)
        return move
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
