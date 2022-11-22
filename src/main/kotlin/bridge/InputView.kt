package bridge

import bridge.constant.*

class InputView {

    fun readBridgeSize(): Int {
        println(REQUEST_INPUT_BRIDGE_SIZE_MSG)
        while (true) {
            try {
                val bridgeSize = camp.nextstep.edu.missionutils.Console.readLine().toInt()
                require(bridgeSize in 3..20)
                return bridgeSize
            } catch (e: IllegalArgumentException) {
                println(ERROR_INPUT_BRIDGE_SIZE)
            }
        }
    }

    fun readMoving(): String {
        println(REQUEST_INPUT_MOVE_MSG)
        while (true) {
            try {
                val mv = camp.nextstep.edu.missionutils.Console.readLine()
                require(mv == UP_SIDE || mv == DOWN_SIDE)
                return mv
            } catch (e: IllegalArgumentException) {
                println(ERROR_INPUT_PLAYER_MOVE)
            }
        }
    }


    fun readGameCommand(): String {
        println(REQUEST_INPUT_QUIT_OR_RETRY_MSG)
        while (true) {
            try {
                val command = camp.nextstep.edu.missionutils.Console.readLine()
                require(command == QUIT_GAME || command == RETRY_GAME)
                return command
            } catch (e: IllegalArgumentException) {
                println(ERROR_INPUT_COMMAND)
            }
        }
    }
}
