package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private val validator = Validator()
    fun readBridgeSize(): Int {
        val bridgeSize = Console.readLine()
        try {
            validator.validateBridgeSize(bridgeSize)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readBridgeSize()
        }
        return bridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val move = Console.readLine()
        try {
            validator.validatorMove(move)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readMoving()
        }
        return move
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val command = Console.readLine()
        try {
            validator.validatorGameCommand(command)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readGameCommand()
        }
        return command
    }
}
