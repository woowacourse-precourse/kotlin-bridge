package bridge.view

import bridge.domain.GameCommand
import bridge.InputValidator
import bridge.domain.Direction
import bridge.sentence.InputSentence
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        InputSentence.BRIDGE_LENGTH.print()
        val input = Console.readLine()
        InputValidator.validateDigitNumber(input)
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): Direction {
        InputSentence.MOVE.print()
        val input = Console.readLine()
        return Direction.getDirection(input)
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): GameCommand {
        InputSentence.RESTART.print()
        val input = Console.readLine()
        return GameCommand.getGameCommand(input)
    }
}
