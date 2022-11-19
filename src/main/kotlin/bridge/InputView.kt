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
        if (bridgeSize.toIntOrNull() !in BRIDGE_SIZE_MIN..BRIDGE_SIZE_MAX) throw IllegalArgumentException(ERROR_BRIDGE_SIZE_MESSAGE)
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    tailrec fun readMoving(): String {
        println(MOVING_MESSAGE)
        val moving = Console.readLine()
        return if (runCatching{validateMoving(moving)}.onFailure { println(ERROR_MOVING_MESSAGE) }.isSuccess) moving
        else readMoving()
    }
    @Throws(IllegalArgumentException::class)
    fun validateMoving(moving: String) {
        val movingList = listOf(MOVING_UP, MOVING_DOWN)
        if (!movingList.contains(moving)) throw IllegalArgumentException(ERROR_MOVING_MESSAGE)
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    tailrec fun readGameCommand(): String {
        println(GAME_COMMAND_MESSAGE)
        val gameCommand = Console.readLine()
        return if (runCatching{validateGameCommand(gameCommand)}.onFailure { println(ERROR_GAME_COMMAND_MESSAGE) }.isSuccess) gameCommand
        else readGameCommand()
    }
    @Throws(IllegalArgumentException::class)
    fun validateGameCommand(gameCommand: String) {
        val gameCommandList = listOf(GAME_RESTART, GAME_QUIT)
        if (!gameCommandList.contains(gameCommand)) throw IllegalArgumentException(ERROR_GAME_COMMAND_MESSAGE)
    }

    companion object {
        private const val BRIDGE_SIZE_MIN = 3
        private const val BRIDGE_SIZE_MAX = 20
        private const val MOVING_UP = "U"
        private const val MOVING_DOWN = "D"
        private const val GAME_RESTART = "R"
        private const val GAME_QUIT = "Q"

        private const val BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        private const val MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: ${MOVING_UP}, 아래: ${MOVING_DOWN})"
        private const val GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: ${GAME_RESTART}, 종료: ${GAME_QUIT})"

        private const val ERROR_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 ${BRIDGE_SIZE_MIN}부터 ${BRIDGE_SIZE_MAX}사이의 숫자여야 합니다."
        private const val ERROR_MOVING_MESSAGE = "[ERROR] 이동할 칸은 ${MOVING_UP}또는 ${MOVING_DOWN}여야 합니다."
        private const val ERROR_GAME_COMMAND_MESSAGE = "[ERROR] 게임을 다시 시작할지 종료할지는 ${GAME_RESTART}또는 ${GAME_QUIT}여야 합니다."
    }
}
