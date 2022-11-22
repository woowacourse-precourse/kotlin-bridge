package bridge

import bridge.constants.PrintMessage.READ_BRIDGE_SIZE
import bridge.constants.PrintMessage.READ_GAME_COMMAND
import bridge.constants.PrintMessage.READ_MOVING
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputErrorCheck = InputErrorCheck()

    fun readBridgeSize(): Int {
        println(READ_BRIDGE_SIZE)
        val bridgeSize = Console.readLine()
        inputErrorCheck.checkValidBridgeSize(bridgeSize)
        println()
        return bridgeSize.toInt()
    }

    fun readMoving(): String {
        println(READ_MOVING)
        val moving = Console.readLine()
        inputErrorCheck.throwMovingException(moving)
        return moving
    }

    fun readGameCommand(): String {
        println(READ_GAME_COMMAND)
        val gameCommand = Console.readLine()
        inputErrorCheck.throwGameCommandException(gameCommand)
        return gameCommand
    }
}
