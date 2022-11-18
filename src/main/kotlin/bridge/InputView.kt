package bridge

import camp.nextstep.edu.missionutils.Console
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    tailrec fun readBridgeSize(): Int {
        println(BRIDGE_SIZE_MESSAGE)
        val bridgeSize = Console.readLine()
        return if (runCatching{validateBridgeSize(bridgeSize)}.onFailure { println(ERROR_BRIDGE_SIZE_MESSAGE) }.isSuccess) bridgeSize.toInt()
        else readBridgeSize()
    }
    @Throws(IllegalArgumentException::class)
    fun validateBridgeSize(bridgeSize: String) {
        if (bridgeSize.toIntOrNull() !in 3..20) throw IllegalArgumentException(ERROR_BRIDGE_SIZE_MESSAGE)
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(MOVING_MESSAGE)
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(GAME_COMMAND_MESSAGE)
        return ""
    }

    companion object {
        private const val BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        private const val MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

        private const val ERROR_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }
}
