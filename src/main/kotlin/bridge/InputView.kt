package bridge

import camp.nextstep.edu.missionutils.Console


const val UP = "U"
const val QUIT = "Q"

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

        fun readMoving(): Int {
            val userInput = Console.readLine()
            BridgeException.isitUorD(userInput)
            if (userInput == UP)
                return BridgeParameter.Up.value
            return BridgeParameter.Down.value
        }

        fun readGameCommand(): Boolean {
            val userInput = Console.readLine()

            //R이나 Q인지 확인하는 예외처리 작성

            return userInput == QUIT
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
}
