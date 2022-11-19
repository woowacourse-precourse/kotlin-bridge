package ui

import bridge.InputInspector
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    private val inspector: InputInspector = InputInspector()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var input: String = ""

        while (true) {
            try {
                input = Console.readLine()
                if (inspector.checkBridgeSize(input)) return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(ERROR_MESSAGE + BRIDGE_LENGTH_ONLY_BETWEEN_3_AND_20)
                continue
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR]"
        const val BRIDGE_LENGTH_ONLY_BETWEEN_3_AND_20 = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
        const val MOVING_ONLY_U_OR_D = "이동할 칸은 'U' 또는 'D' 둘 중 하나여야 합니다."
        const val COMMAND_ONLY_R_OR_Q = "재실행 여부는 'R' 또는 'Q' 둘 중 하나여야 합니다."
    }
}
