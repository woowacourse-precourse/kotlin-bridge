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
        val bridgeSize = Console.readLine()

        if(!bridgeSize.chars().allMatch { Character.isDigit(it) }) {
            println("[ERROR] 입력한 다리 길이는 정수가 아닙니다.")
            return 0
        }

        BridgeSizeException(bridgeSize)

        return bridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val moveCommand = Console.readLine()
        BridgeMoveException(moveCommand)

        return moveCommand
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val gameCommand = Console.readLine()
        GameCommandException(gameCommand)

        return gameCommand
    }
}
