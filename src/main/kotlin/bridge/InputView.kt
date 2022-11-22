package bridge

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    private val exceptions = Exceptions()

    fun readBridgeSize(): Int {
        val size = readLine()
        exceptions.validateBridgeSize(size)
        return size.toInt()
    }

    fun readMoving(): String {
        val moveState = readLine()
        exceptions.validateMoving(moveState)
        return moveState
    }

    fun readGameCommand(): String {
        val command = readLine()
        exceptions.validateCommand(command)
        return command
    }
}