package bridge

import camp.nextstep.edu.missionutils.Console


const val up = "U"

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
            val userinput = Console.readLine()
            BridgeException.isitUorD(userinput)
            if (userinput == up)
                return BridgeParameter.Up.value
            return BridgeParameter.Down.value
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
