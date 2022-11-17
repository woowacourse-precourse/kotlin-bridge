package bridge.view

import bridge.util.Converter
import bridge.validation.InputValidation
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val inputValidation = InputValidation()
    private val converter = Converter()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE_MESSAGE)
        val input = Console.readLine()
        inputValidation.checkInputInteger(input)
        val bridgeSize = converter.convertStringToInt(input)
        inputValidation.checkBridgeSizeRange(bridgeSize)
        return bridgeSize
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
        const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
    }
}
