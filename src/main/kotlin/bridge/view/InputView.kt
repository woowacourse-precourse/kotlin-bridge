package bridge.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun askBridgeSizeToUser(): Int {
        println(REQUEST_BRIDGE_SIZE_MESSAGE)
        while (true)
            try {
                return readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }

    fun readBridgeSize(): Int {
        val readValue = Console.readLine()
        validateBridgeSize(readValue)
        return readValue.toInt()
    }

    private fun validateBridgeSize(readValue: String) =
        require(readValue.matches(Regex("[1-9][0-9]?")) && readValue.toInt() in MIN_BRIDGE_SIZE..MAX_BRIDGE_SIZE) { BRIDGE_SIZE_ERROR_MESSAGE }

    fun askMovingToUser(): String {
        println(REQUEST_MOVE_DIRECTION_MESSAGE)
        while (true)
            try {
                return readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }

    fun readMoving(): String {
        val readValue = Console.readLine()
        validateReadMoving(readValue)
        return readValue
    }

    private fun validateReadMoving(readValue: String) =
        require(readValue == UP || readValue == DOWN) { MOVE_DIRECTION_ERROR_MESSAGE }

    fun askRetryToUser(): Boolean {
        println(REQUEST_GAME_COMMAND_MESSAGE)
        while (true)
            try {
                return readGameCommand() == RETRY
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }

    fun readGameCommand(): String {
        val readValue = Console.readLine()
        validateGameCommand(readValue)
        return readValue
    }

    private fun validateGameCommand(readValue: String) =
        require(readValue == RETRY || readValue == QUIT) { GAME_COMMAND_ERROR_MESSAGE }

    companion object {
        private const val REQUEST_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        private const val REQUEST_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val REQUEST_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

        private const val ERROR_MESSAGE_HEADER = "[ERROR] "
        private const val BRIDGE_SIZE_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "3 이상 20 이하의 숫자로 입력바랍니다."
        private const val MOVE_DIRECTION_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "U(위) 또는 D(아래)를 입력바랍니다."
        private const val GAME_COMMAND_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "R(재시도) 또는 Q(종료)를 입력바랍니다."

        private const val MIN_BRIDGE_SIZE = 3
        private const val MAX_BRIDGE_SIZE = 20
        private const val UP = "U"
        private const val DOWN = "D"
        private const val RETRY = "R"
        private const val QUIT = "Q"
    }
}
