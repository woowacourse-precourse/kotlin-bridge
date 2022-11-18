package bridge.view

import bridge.common.toIntOrThrow
import bridge.constants.ErrorMessage
import bridge.domain.Bridge
import camp.nextstep.edu.missionutils.Console.readLine

object InputView {

    private const val RETRY = "R"
    private const val QUIT = "Q"

    fun readBridgeSize(): Int {
        val bridgeSize = readLine().toIntOrThrow()

        require(bridgeSize in Bridge.SizeRange) {
            ErrorMessage.OutOfBridgeSize
        }

        return bridgeSize
    }

    fun readMoving(): String {
        val bridgeType = readLine()

        require(Bridge.Element.contains(bridgeType)) {
            ErrorMessage.InvalidBridgeElement
        }

        return bridgeType
    }

    fun askRetryGame(): Boolean {
        val command = readLine()

        require(command == RETRY || command == QUIT) {
            ErrorMessage.InvalidGameCommand
        }

        return command == RETRY
    }
}
