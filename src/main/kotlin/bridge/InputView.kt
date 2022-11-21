package bridge

import camp.nextstep.edu.missionutils.Console


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    companion object {
        fun readBridgeSize(): Int {
            val size = Console.readLine()
            BridgeException.checkNumber(size)
            BridgeException.sizeCheck(size.toInt())
            return size.toInt()
        }

        fun readMoving(): String {
            val userInput = Console.readLine()
            BridgeException.isitUorD(userInput)
            return userInput
        }

        fun readGameCommand(): Boolean {
            val userInput = Console.readLine()
            BridgeException.isitRorQ(userInput)
            return userInput == BridgeMessage.QUIT.word
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
}
