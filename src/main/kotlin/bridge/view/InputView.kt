package bridge.view

import bridge.utils.UserInputValidate
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val userInputValidate = UserInputValidate()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("\n다리의 길이를 입력해주세요.")
        return userInputValidate.validateBridgeSize(Console.readLine())
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return userInputValidate.validateMoving(Console.readLine())
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
