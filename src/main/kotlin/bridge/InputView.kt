package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView(private val inputValidator: InputValidator) {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var bridgeSize = ""
        do {
            val isValidate = kotlin.runCatching {
                println("다리의 길이를 입력해주세요.\n")
                bridgeSize = Console.readLine()
                inputValidator.validateBridgeInput(bridgeSize)
            }
        } while (isValidate.isFailure)
        return bridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var direction = ""
        do {
            val isValidate = kotlin.runCatching {
                println("이동할 칸을 선택해주세요. (위: U, 아래: D)\n")
                direction = Console.readLine()
                inputValidator.validateMoveInput(direction)
            }
        } while (isValidate.isFailure)
        return direction
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val retryInput = ""
        do {
            val isValidate = kotlin.runCatching {
                println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n")
                val retryFlag = Console.readLine()
                inputValidator.validateRetryFlag(retryFlag)
            }
        } while (isValidate.isFailure)
        return retryInput
    }
}
