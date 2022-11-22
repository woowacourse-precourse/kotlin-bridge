package bridge.view

import constant.Message

class InputView {
    fun readBridgeSize(): Int {
        var input: String?
        var numberOfRetry = 0
        do {
            println(Message.BRIDGE_SIZE_INPUT.message)
            input = readLine()
            val retry = BridgeSizeChecker(input).checkAll()
            numberOfRetry++
            if (numberOfRetry > 4) return 0
        } while (retry)
        return input?.toInt() ?: 0
    }

    fun readMoving(): String {
        var input: String?
        do {
            println(Message.MOVING_INPUT.message)
            input = readLine()
            val retry = MovingChecker(input).checkAll()
            if (retry) println()
        } while (retry)
        return input ?: ""
    }

    fun readGameCommand(): String {
        var input: String?
        do {
            println(Message.GAME_COMMAND_INPUT.message)
            input = readLine()
            val retry = CommandChecker(input).checkAll()
            if (retry) println()
        } while (retry)
        return input ?: ""
    }
}
