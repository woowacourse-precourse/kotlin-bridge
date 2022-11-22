package bridge.View

import bridge.util.Validator
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        while (true) {
            try {
                var size = Console.readLine()
                Validator.checkBridgeSize(size)
                return size.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            try {
                var move = Console.readLine()
                Validator.checkBridgeSelect(move)
                return move
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            try {
                var command = Console.readLine()
                Validator.checkCommand(command)
                return command
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
