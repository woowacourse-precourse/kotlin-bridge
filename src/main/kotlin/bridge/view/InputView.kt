package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
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

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val readValue = Console.readLine()
        validateBridgeSize(readValue)
        return readValue.toInt()
    }

    private fun validateBridgeSize(readValue: String) =
        require(readValue.matches(Regex("[1-9][0-9]?")) && readValue.toInt() in 3..20) { BRIDGE_SIZE_ERROR_MESSAGE }

    fun askMovingToUser(): String {
        println(REQUEST_MOVE_DIRECTION_MESSAGE)
        while (true)
            try {
                return readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val readValue = Console.readLine()
        validateReadMoving(readValue)
        return readValue
    }

    private fun validateReadMoving(readValue: String) =
        require(readValue == "U" || readValue == "D") { MOVE_DIRECTION_ERROR_MESSAGE }

    fun askRetryToUser(): Boolean {
        println(REQUEST_GAME_COMMAND_MESSAGE)
        while (true)
            try {
                return readGameCommand() == "R"
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val readValue = Console.readLine()
        validateGameCommand(readValue)
        return readValue
    }

    private fun validateGameCommand(readValue: String) =
        require(readValue == "R" || readValue == "Q") { GAME_COMMAND_ERROR_MESSAGE }

    companion object {
        private const val REQUEST_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        private const val REQUEST_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val REQUEST_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

        private const val ERROR_MESSAGE_HEADER = "[ERROR] "
        private const val BRIDGE_SIZE_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "3 이상 20 이하의 숫자로 입력바랍니다."
        private const val MOVE_DIRECTION_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "U(위) 또는 D(아래)를 입력바랍니다."
        private const val GAME_COMMAND_ERROR_MESSAGE = ERROR_MESSAGE_HEADER + "R(재시도) 또는 Q(종료)를 입력바랍니다."
    }
}
