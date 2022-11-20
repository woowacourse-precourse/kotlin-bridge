package bridge
import camp.nextstep.edu.missionutils.Console
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    val util = Util()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val input = Console.readLine()
        util.isInt(input)
        val inputNum = input.toInt()
        util.isInRange(inputNum)
        return inputNum
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val input = Console.readLine()
        util.isUD(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input = Console.readLine()
        util.isRQ(input)
        return input
    }
}
