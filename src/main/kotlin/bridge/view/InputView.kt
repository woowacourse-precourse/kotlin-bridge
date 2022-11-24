package bridge.view

import bridge.util.toIntOrThrow
import bridge.common.ErrorMessage
import bridge.domain.game.Bridge
import bridge.view.strings.Command
import camp.nextstep.edu.missionutils.Console.readLine

object InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine().toIntOrThrow()

        require(bridgeSize in Bridge.SizeRange) {
            ErrorMessage.OutOfBridgeSize
        }

        return bridgeSize
    }

    fun readNextFloor(): Bridge.Floor {
        val nextFloor = requireNotNull(Bridge.Floor.parse(readLine())) {
            ErrorMessage.InvalidBridgeMoving
        }

        return nextFloor
    }

    fun askRetryGame(): Boolean {
        val command = requireNotNull(Command.Power.parse(readLine())) {
            ErrorMessage.InvalidGameRetryCommand
        }

        return command == Command.Power.Retry
    }
}
