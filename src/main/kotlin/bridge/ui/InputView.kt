package bridge.ui

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private var bridgeSize = ""

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        bridgeSize = Console.readLine()
        validateBridgeSize(bridgeSize)
        return bridgeSize.toInt()
    }

    private fun validateBridgeSize(bridgeSize: String) {
        try {
            val validator = Validator()
            validator.handleMixedCharCase(bridgeSize) // 숫자인지 먼저 검사
            validator.handleOutOfRangeCase(bridgeSize.toInt()) // 범위에 해당하는지 검사
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBridgeSize() // 다시 입력 받기
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
}
