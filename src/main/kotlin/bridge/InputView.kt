package bridge
import bridge.utils.Messages
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(Messages.GameStart)
        println()
        println(Messages.InputLength)
        val input = Console.readLine().toInt()
        return input
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(Messages.InputUpAndDown)
        val input = Console.readLine()
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(Messages.GameRestart)
        val input = Console.readLine()
        return input
    }
}
