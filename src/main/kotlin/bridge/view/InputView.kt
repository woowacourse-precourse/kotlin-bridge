package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 물어본다.
     */
    fun askBridgeSize(): String {
        println(BRIDGE_SIZE_INSTRUCTION)
        return readInput()
    }

    /**
     * 사용자가 이동할 칸을 물어본다.
     */
    fun askMovement(): String {
        println(MOVEMENT_INSTRUCTION)
        return readInput()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 물어본다.
     */
    fun askGameCommand(): String {
        return ""
    }

    private fun readInput(): String {
        return Console.readLine()
    }

    companion object {
        const val BRIDGE_SIZE_INSTRUCTION = "다리의 길이를 입력해주세요."
        const val MOVEMENT_INSTRUCTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    }
}
