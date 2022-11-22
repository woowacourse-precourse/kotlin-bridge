package bridge.ui

import bridge.util.ConstantMessage
import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun chkNum(str: String): Boolean {
        var temp: Char
        var result = false
        for (i in 0 until str.length) {
            temp = str.elementAt(i)
            if (temp.toInt() < 48 || temp.toInt() > 57) {
                result = true
            }
        }
        return result
    }

    fun readBridgeSize(): Int {
        try {
            println(ConstantMessage.INPUT_BRIDGE_SIZE)
            val bridgeSize = Console.readLine()
            inputBridgeException(bridgeSize)
            return bridgeSize.toInt()
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            return readBridgeSize()
        }
    }

    fun inputBridgeException(bridgeSize: String) {
        when {
            bridgeSize.isBlank() -> throw IllegalArgumentException(ConstantMessage.INPUT_TYPE_EXCEPTION)
            chkNum(bridgeSize) -> throw IllegalArgumentException(ConstantMessage.INPUT_TYPE_EXCEPTION)
            bridgeSize.toInt() < 3 -> throw IllegalArgumentException(ConstantMessage.INPUT_MORE_RANGE_EXCEPTION)
            bridgeSize.toInt() > 20 -> throw IllegalArgumentException(ConstantMessage.INPUT_LESS_RANGE_EXCEPTION)
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        try {
            println(ConstantMessage.INPUT_SELECT_MOVE)
            val inputMoving = Console.readLine()
            inputMovingException(inputMoving)
            return inputMoving
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            return readMoving()
        }
    }

    fun inputMovingException(inputMoving: String) {
        when {
            inputMoving != "U" && inputMoving != "D" -> return throw IllegalArgumentException(ConstantMessage.INPUT_MOVE_EXCEPTION)
        }
    }

    fun readGameCommand(): String {
        try {
            println(ConstantMessage.INPUT_GAME_COMMAND)
            val inputGameCommand = Console.readLine()
            inputGameCommandException(inputGameCommand)
            return inputGameCommand
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            return readGameCommand()
        }

    }

    fun inputGameCommandException(inputGameCommand: String) {
        when {
            inputGameCommand != "Q" && inputGameCommand != "R" -> return throw IllegalArgumentException(ConstantMessage.INPUT_GAME_COMMAND_EXCEPTION)
        }
    }
}