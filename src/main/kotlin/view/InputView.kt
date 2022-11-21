package view

import camp.nextstep.edu.missionutils.Console
import domain.BridgeMaker
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    val MESSAGE_ERROR = "[ERROR]"

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        try {
            val bridgeSize = Console.readLine().toInt()
            if (bridgeSize in 3..20)
                return bridgeSize
        }catch (e: IllegalArgumentException){
            throw IllegalArgumentException("$MESSAGE_ERROR $e")
        }
        throw IllegalArgumentException("$MESSAGE_ERROR 잘못된 입력 값입니다.")
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        try {
            val move = Console.readLine()
            if (move == "U"|| move == "D" )
                return move
        }catch (e: IllegalArgumentException){
            throw IllegalArgumentException("$MESSAGE_ERROR $e")
        }
        throw IllegalArgumentException("$MESSAGE_ERROR 잘못된 입력 값입니다.")
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        try {
            val retry = Console.readLine()
            if (retry == "R"|| retry == "Q" )
                return retry
        }catch (e: IllegalArgumentException){
            throw IllegalArgumentException("$MESSAGE_ERROR $e")
        }
        throw IllegalArgumentException("$MESSAGE_ERROR 잘못된 입력 값입니다.")
    }

}
