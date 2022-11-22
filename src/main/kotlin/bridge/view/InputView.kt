package bridge.view

import bridge.utils.ExceptionChecker
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val exceptionChecker = ExceptionChecker()
    private val outputView = OutputView()

    fun readBridgeSize(): Int {
        outputView.printReadBridgeSizeMessage()
        val bridgeSize = Console.readLine()
        exceptionChecker.bridgeSizeIsDigitException(bridgeSize)
        exceptionChecker.bridgeSizeIsInRangeException(bridgeSize.toInt())
        return bridgeSize.toInt()
    }

    fun readMoving(): String {
        outputView.printReadMovingMessage()
        val userMove = Console.readLine()
        exceptionChecker.movingException(userMove)
        return userMove
    }

    fun readGameCommand(): String {
        outputView.printReadGameCommandMessage()
        val command = readLine()!!
        exceptionChecker.gameCommandException(command)
        return command
    }
}
