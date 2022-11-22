package bridge.view

import bridge.util.toIntOrThrow
import bridge.constants.ErrorMessage
import bridge.data.Bridge
import camp.nextstep.edu.missionutils.Console.readLine

object InputView {

    const val RETRY = "R"
    const val QUIT = "Q"

    fun readBridgeSize(): Int {
        val bridgeSize = readLine().toIntOrThrow()

        require(bridgeSize in Bridge.SizeRange) {
            ErrorMessage.OutOfBridgeSize
        }

        return bridgeSize
    }

    fun readMoving(): Bridge.Floor {
        val command = readLine()

        return requireNotNull(Bridge.Floor.getOrNull(command)) {
            ErrorMessage.InvalidBridgeMoving
        }
    }

    fun askRetryGame(): Boolean {
        val command = readLine()

        require(command == RETRY || command == QUIT) {
            ErrorMessage.InvalidGameRetryCommand
        }

        return command == RETRY
    }
}
