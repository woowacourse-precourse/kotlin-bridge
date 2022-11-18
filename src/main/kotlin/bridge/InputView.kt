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
        val moving = readLine()
        exceptions.validateMoving(moving)
        return moving
    }

    fun readGameCommand(): String {
        val command = readLine()
        exceptions.validateCommand(command)
        return command
    }

}
