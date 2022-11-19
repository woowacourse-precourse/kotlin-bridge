package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
        println(BRIDGE_SIZE_INSTRUCTION)
        return readLine()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMovement(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun readLine(): String {
        return Console.readLine()
    }

    companion object {
        const val BRIDGE_SIZE_INSTRUCTION = "다리의 길이를 입력해주세요."
    }
}
