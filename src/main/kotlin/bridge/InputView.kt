package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val bridgeSize = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("다리 길이는 숫자여야 합니다.")
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw IllegalArgumentException("다리 길이는 3 이상 20 이하의 숫자여야 합니다.")
        }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val move = Console.readLine()
        if (move.length != 1)
            throw IllegalArgumentException("이동할 칸은 하나의 문자여야 합니다.")
        if (!(move == "U" || move == "D"))
            throw IllegalArgumentException("이동할 칸은 문자 U거나 D여야 합니다.")
        return move
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val cmd = Console.readLine()
        if (cmd.length != 1)
            throw IllegalArgumentException("명령어는 하나의 문자여야 합니다.")
        if (!(cmd == "R" || cmd == "Q"))
            throw IllegalArgumentException("명령어는 문자 R이거나 Q여야 합니다.")
        return cmd
    }
}
