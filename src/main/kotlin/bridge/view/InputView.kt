package bridge.view

import bridge.util.Converter
import bridge.validation.InputValidation
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(inputValidation: InputValidation,converter: Converter): Int {
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
    fun readMoving(inputValidation: InputValidation): String {
        println(INPUT_MOVING_MESSAGE)
        val moving = Console.readLine()
        inputValidation.checkInputLength(moving)
        inputValidation.checkUserMovingValidation(moving)
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        const val INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    }
}
