package bridge.view

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.utils.ErrorMessage
import bridge.utils.Print
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        Print.showInputBridgeLength()
        while (true) {
            try {
                val bridgeLength = Console.readLine().trim()
                require(bridgeLength.toInt() in MIN_LENGTH..MAX_LENGTH)
                return bridgeLength.toInt()
            } catch (e: IllegalArgumentException) {
                Print.showErrorMessage(ErrorMessage.ERROR_LENGTH)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        Print.showInputMove()
        while (true) {
            try {
                val moveStair = Console.readLine().trim()
                require(moveStair == BridgeMaker.UP_STAIR || moveStair == BridgeMaker.DOWN_STAIR)
                return moveStair
            } catch (e: IllegalArgumentException) {
                Print.showErrorMessage(ErrorMessage.ERROR_INPUT)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        Print.showRestart()
        while (true) {
            try {
                val command = Console.readLine().trim()
                require(command == BridgeGame.RESTART_COMMAND || command == BridgeGame.EXIT_COMMAND)
                return command
            } catch (e: IllegalArgumentException) {
                Print.showErrorMessage(ErrorMessage.ERROR_COMMAND)
            }
        }
    }

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20
    }
}
