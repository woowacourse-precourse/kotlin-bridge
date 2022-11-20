package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    private val outputView = OutputView()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
        outputView.printBridgeLength()
        val size = Console.readLine()
        return size
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        outputView.printBridgeDirection()
        val direction = Console.readLine()
        return direction
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        outputView.printGameRetry()
        val command = Console.readLine()
        return command
    }
}
