package bridge.view

import bridge.exceptions.InputExceptions
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readBridgeSize(): Int {
        return try {
            val size = Console.readLine()
            InputExceptions.validateBridgeSize(size)
            return size.toInt()
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readBridgeSize()
        }
    }

    fun readMoving(): String {
        return try {
            val direction = Console.readLine()
            InputExceptions.validateInputMove(direction)
            return direction
        } catch (error: Exception) {
            println(error.message)
            readMoving()
        }
    }

    fun readGameCommand(): String {
        return try {
            val command = Console.readLine()
            InputExceptions.validateInputRestart(command)
            return command
        } catch (error: Exception) {
            println(error.message)
            readGameCommand()
        }
    }
}
