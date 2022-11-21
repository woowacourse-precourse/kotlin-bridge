package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        printInputBridgeSizeMessage()
        val bridgeSize = Console.readLine()
        checkNotNumber(bridgeSize)
        checkNotInRange(bridgeSize)
        return bridgeSize.toInt()
    }

    private fun checkNotInRange(bridgeSize: String) {
        if (bridgeSize.toInt() !in 3..20) throw IllegalArgumentException(NOT_IN_RANGE_MESSAGE)
    }

    private fun checkNotNumber(bridgeSize: String) {
        if (bridgeSize.toIntOrNull() == null) throw IllegalArgumentException(NOT_NUMBER_MESSAGE)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        printMovingMessage()
        val moveSize = Console.readLine()
        checkNotString(moveSize)
        checkUpDown(moveSize)
        return moveSize
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        printRetryMessage()
        val gameCommand = Console.readLine()
        checkNotString(gameCommand)
        checkRetry(gameCommand)
        return gameCommand
    }

    private fun checkNotString(bridgeSize: String) {
        if (bridgeSize.toIntOrNull() != null) throw IllegalArgumentException(NOT_STRING_MESSAGE)
    }

    private fun checkUpDown(readLine: String) {
        if (readLine != UP && readLine != DOWN) {
            throw IllegalArgumentException(NOT_UP_DOWN_MESSAGE)
        }
    }

    private fun checkRetry(readLine: String) {
        if (readLine != RETRY && readLine != QUIT) {
            throw IllegalArgumentException(NOT_RETRY_QUIT_MESSAGE)
        }
    }

    private fun printInputBridgeSizeMessage() = println(INPUT_BRIDGE_SIZE_MESSAGE)
    private fun printMovingMessage() = println(MOVING_MESSAGE)
    private fun printRetryMessage() = println(RETRY_MESSAGE)

    companion object {
        const val UP = "U"
        const val DOWN = "D"
        const val RETRY = "R"
        const val QUIT = "Q"
        const val INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요."
        const val NOT_STRING_MESSAGE = "[ERROR] 문자만 입력해주세요."
        const val NOT_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해주세요."
        const val NOT_IN_RANGE_MESSAGE = "[ERROR] 3 부터 20 사이의 숫자만 입력해주세요."
        const val NOT_UP_DOWN_MESSAGE = "[ERROR] U 또는 D 를 입력해주세요"
        const val NOT_RETRY_QUIT_MESSAGE = "[ERROR] R 또는 Q 를 입력해주세요"
        const val MOVING_MESSAGE = "\n이동할 칸을 선택해 주세요. (위: U, 아래: D)"
        const val RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를입력해주세요. (재시도:R, 종료:Q)"
    }
}
