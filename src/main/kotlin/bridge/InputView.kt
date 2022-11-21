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
            val isValidate = runCatching {
                println(ASK_BRIDGE_SIZE)
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
            val isValidate = runCatching {
                println(ASK_MOVE)
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
        var retryInput = ""
        do {
            val isValidate = runCatching {
                println(ASK_RETRY)
                retryInput = Console.readLine()
                inputValidator.validateRetryFlag(retryInput)
            }
        } while (isValidate.isFailure)
        return retryInput
    }

    companion object {
        const val ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.\n"
        const val ASK_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n"
        const val ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"
    }
}
