package bridge
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    companion object {
        /**
         * 다리의 길이를 입력받는다.
         */
        fun readBridgeSize(): Int {
            OutputView.messageInputBridgeSize()
            val bridgeSize = Console.readLine()
            ExceptionCheck.checkBridgeSize(bridgeSize)
            return bridgeSize.toInt()
        }

        /**
         * 사용자가 이동할 칸을 입력받는다.
         */
        fun readMoving(): String {
            OutputView.messageInputMove()
            val movingDirection = Console.readLine()
            ExceptionCheck.checkDirection(movingDirection)
            return movingDirection
        }

        /**
         * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
         */
        fun readGameCommand(): String {
            OutputView.messageInputGameCommand()
            val gameCommand = Console.readLine()
            ExceptionCheck.checkGameCommand(gameCommand)
            return gameCommand
        }
    }
}
