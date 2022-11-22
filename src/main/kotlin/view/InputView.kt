package view

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {

    fun readBridgeSize(): String {
        println(READ_BRIDGE_SIZE)
        val bridgeSize = Console.readLine()
        println()
        return bridgeSize
    }

    fun readMoving(): String {
        println(READ_MOVE)
        return Console.readLine()
    }

    fun readGameCommand(): String {
        println(READ_COMMAND)
        return Console.readLine()
    }

    fun inputValidBridgeSize(): Int {
        var bridgeSize = 0
        try {
            bridgeSize = readBridgeSize().toInt()
            require(bridgeSize in 3..20) { READ_BRIDGE_SIZE_ERROR_MESSAGE }
        } catch (exception: IllegalArgumentException) {
            print(READ_BRIDGE_SIZE_ERROR_MESSAGE)
        }
        return bridgeSize
    }

    fun inputValidMove(): String {
        val move = readMoving()
        require(move == UP || move == DOWN) { READ_MOVE_ERROR_MESSAGE }
        return move
    }

    fun inputValidCommand(): String {
        val command = readGameCommand()
        require(command == RESTART || command == QUIT) { READ_COMMAND_ERROR_MESSAGE }
        return command
    }

    companion object {
        const val READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val READ_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val READ_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val READ_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 3이상 20이하 숫자를 입력해주세요."
        const val READ_MOVE_ERROR_MESSAGE = "[ERROR] \"U\" 나 \"D\"를 입력해주세요."
        const val READ_COMMAND_ERROR_MESSAGE = "[ERROR] \"R\" 이나 \"Q\"를 입력해주세요."
        const val UP = "U"
        const val DOWN = "D"
        const val RESTART = "R"
        const val QUIT = "Q"
    }
}
