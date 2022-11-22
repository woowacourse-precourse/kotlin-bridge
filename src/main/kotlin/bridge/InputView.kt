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
        while(true) {
            try {
                val bridgeSize = Console.readLine()
                BridgeSizeException(bridgeSize)
                return bridgeSize.toInt()
            }catch (e: IllegalArgumentException) {
                OutputView().printException(InputType.BRIDGE_SIZE, e.message!!)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while(true) {
            try {
                val moveCommand = Console.readLine()
                BridgeMoveException(moveCommand)
                return moveCommand
            }catch (e: IllegalArgumentException) {
                OutputView().printException(InputType.BRIDGE_MOVE, e.message!!)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while(true) {
            try {
                val gameCommand = Console.readLine()
                GameCommandException(gameCommand)
                return gameCommand
            }catch (e: IllegalArgumentException) {
                OutputView().printException(InputType.GAME_COMMAND, e.message!!)
            }
        }
    }
}
