package bridge.view

import bridge.common.GameCommand
import camp.nextstep.edu.missionutils.Console.readLine

class InputView(private val inputValidator: InputValidator) {
    fun readBridgeSize(): Int {
        val brideSize = readLine()
        inputValidator.checkBridgeSizeInputValid(brideSize)
        return brideSize.toInt()
    }

    fun readMoving(): String {
        val direction = readLine()
        inputValidator.checkMovingInputValid(direction)
        return direction
    }

    fun readGameCommand(): GameCommand {
        val command = readLine()
        return inputValidator.checkGameCommandValid(command)
    }
}
