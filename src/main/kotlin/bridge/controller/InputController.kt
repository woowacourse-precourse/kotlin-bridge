package bridge.controller

import bridge.domain.BridgeNumber
import bridge.domain.Command
import bridge.domain.Movement
import bridge.view.InputView

class InputController {
    fun getBridgeSize(): Int {
        try {
            val size = InputView().readBridgeSize()
            BridgeNumber(size)
            return size.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getBridgeSize()
        }
    }

    fun getBridgeMoving(): String {
        try {
            val direction = InputView().readMoving()
            Movement(direction)
            return direction
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getBridgeMoving()
        }
    }

    fun getBridgeCommand(): String {
        try {
            val command = InputView().readGameCommand()
            Command(command)
            return command
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getBridgeCommand()
        }
    }
}