package bridge.ui

import bridge.domain.data.BridgeErrorText
import bridge.domain.data.BridgeKeyword
import bridge.domain.data.BridgeNumber
import bridge.domain.data.BridgeOutputText
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(BridgeOutputText.BRIDGE_SIZE.text)
        val userInputText = Console.readLine()
        requireNotNull(userInputText.toIntOrNull()) {
            print(BridgeErrorText.ONLY_NUMBER.text)
            return readBridgeSize()
        }
        require(userInputText.toInt() in BridgeNumber.MIN_BRIDGE_SIZE.number..BridgeNumber.MAX_BRIDGE_SIZE.number) {
            println(BridgeErrorText.ONLY_RANGE.text)
            return readBridgeSize()
        }
        return userInputText.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(BridgeOutputText.CHOOSE_ROWS.text)
        val userInputText = Console.readLine()
        require(userInputText == BridgeKeyword.UP.keyword || userInputText == BridgeKeyword.DOWN.keyword) {
            println(BridgeErrorText.ONLY_U_OR_D.text)
            return readMoving()
        }
        return userInputText
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(BridgeOutputText.RETRY_TEXT.text)
        val userInputText = Console.readLine()
        require(userInputText == BridgeKeyword.RETRY.keyword || userInputText == BridgeKeyword.QUIT.keyword) {
            println(BridgeErrorText.ONLY_R_OR_Q.text)
            return readGameCommand()
        }
        return userInputText
    }
}
