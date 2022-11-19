package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    fun askBridgeSizeToUser(): Int {
        println("다리의 길이를 입력해주세요.")
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
        var readValue = Console.readLine()
        validateBridgeSize(readValue)
        return readValue.toInt()
    }

    private fun validateBridgeSize(readValue: String) =
        require(readValue.matches(Regex("[1-9][0-9]?")) && readValue.toInt() in 3..20) { "[ERROR] 3 이상 20 이하의 숫자로 입력바랍니다." }

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
