package bridge.view

import bridge.util.InputValidator
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView(private val inputValidator: InputValidator) {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(ASK_BRIDGE_SIZE)
        while (true) {
            val bridgeSize = Console.readLine()
            try {
                inputValidator.validateBridgeInput(bridgeSize)
                return bridgeSize.toInt()
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(ASK_MOVE)
        while (true) {
            val direction = Console.readLine()
            try {
                inputValidator.validateMoveInput(direction)
                return direction
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(ASK_RETRY)
        while (true) {
            val retryInput = Console.readLine()
            try {
                inputValidator.validateRetryFlag(retryInput)
                return retryInput
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        const val ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.\n"
        const val ASK_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n"
        const val ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"
    }
}
