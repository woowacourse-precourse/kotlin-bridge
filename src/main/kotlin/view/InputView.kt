package view

import camp.nextstep.edu.missionutils.Console
import util.BridgeMessage.DOWN
import util.BridgeMessage.QUIT
import util.BridgeMessage.READ_BRIDGE_SIZE
import util.BridgeMessage.READ_BRIDGE_SIZE_ERROR_MESSAGE
import util.BridgeMessage.READ_COMMAND
import util.BridgeMessage.READ_COMMAND_ERROR_MESSAGE
import util.BridgeMessage.READ_MOVE
import util.BridgeMessage.READ_MOVE_ERROR_MESSAGE
import util.BridgeMessage.RESTART
import util.BridgeMessage.UP
import java.lang.IllegalArgumentException

class InputView {

    fun readBridgeSize(): String {
        println(READ_BRIDGE_SIZE)
        val bridgeSize = Console.readLine()
        println()
        return bridgeSize
    }

    fun readMoving(): String {
        println(READ_MOVE)
        return Console.readLine()
    }

    fun readGameCommand(): String {
        println(READ_COMMAND)
        return Console.readLine()
    }

    fun inputValidBridgeSize(): Int {
        var bridgeSize = 0
        try {
            bridgeSize = readBridgeSize().toInt()
            require(bridgeSize in 3..20) { READ_BRIDGE_SIZE_ERROR_MESSAGE }
        } catch (exception: IllegalArgumentException) {
            print(READ_BRIDGE_SIZE_ERROR_MESSAGE)
        }
        return bridgeSize
    }

    fun inputValidMove(): String {
        val move = readMoving()
        require(move == UP || move == DOWN) { READ_MOVE_ERROR_MESSAGE }
        return move
    }

    fun inputValidCommand(): String {
        val command = readGameCommand()
        require(command == RESTART || command == QUIT) { READ_COMMAND_ERROR_MESSAGE }
        return command
    }
}
