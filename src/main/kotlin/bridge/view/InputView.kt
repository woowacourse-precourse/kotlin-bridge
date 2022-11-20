package bridge.view

import bridge.BridgeMaker
import bridge.utils.ErrorMessage
import bridge.utils.Print
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        Print.showInputBridgeLength()
        while (true) {
            try {
                val bridgeLength = Console.readLine().trim()
                require(bridgeLength.toInt() in 3..20)
                return bridgeLength.toInt()
            } catch (e: IllegalArgumentException) {
                println(ErrorMessage.ERROR_LENGTH)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        Print.showInputMove()
        while (true) {
            try {
                val moveStair = Console.readLine().trim()
                require(moveStair == BridgeMaker.UP_STAIR || moveStair == BridgeMaker.DOWN_STAIR)
                return moveStair
            } catch (e: IllegalArgumentException) {
                println(ErrorMessage.ERROR_INPUT)
            }
        }
    }

}
