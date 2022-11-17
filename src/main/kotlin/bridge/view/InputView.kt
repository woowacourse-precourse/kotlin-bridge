package bridge.view

import bridge.common.toIntOrThrow
import bridge.constants.ErrorMessages
import bridge.data.Bridge
import camp.nextstep.edu.missionutils.Console.readLine

private typealias InputError = ErrorMessages.InputViewEnum

class InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine().toIntOrThrow()

        require(bridgeSize in Bridge.SizeRange) {
            InputError.OutOfBridgeSize
        }

        return bridgeSize
    }

    fun readMoving(): String {
        val bridgeType = readLine()

        require(Bridge.Type.contains(bridgeType)) {
            InputError.InvalidBridgeType
        }

        return bridgeType
    }

    fun askRetryGame(): Boolean {
        val command = readLine()

        require(command != RETRY || command != QUIT) {
            InputError.InvalidGameCommand
        }

        return command == RETRY
    }

    companion object {
        private const val RETRY = "R"
        private const val QUIT = "Q"
    }
}
