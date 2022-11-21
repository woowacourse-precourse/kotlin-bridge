package bridge.View
import bridge.computer.ErrorCheck
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
        println(Messages.InputLength)
        var input = Console.readLine()
        ErrorCheck().MoveKeyWordisNotNumber(input)
        ErrorCheck().BridgeSize(input.toInt())
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(Messages.InputUpAndDown)
        var input = Console.readLine()
        ErrorCheck().MoveKeyWordisDiffer(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(Messages.GameRestart)
        val input = Console.readLine()
        ErrorCheck().ReTrykeyWordld(input)
        return input
    }
}
