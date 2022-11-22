package view

import camp.nextstep.edu.missionutils.Console
import utils.Messages.ERROR_BRIDGE_SIZE
import utils.Messages.ERROR_PREFIX
import java.lang.NumberFormatException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
//        try {
//            val numBridgeSize = readLine()
//        } catch (e: IllgalArgumentException) {
//            println(ERROR_PREFIX+ERROR_BRIDGE_SIZE)
//            return
//        }
        return readLine()!!
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val resultMove = readLine()
        return resultMove.toString()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val resultGameRestart = readLine()
        return resultGameRestart.toString()
    }
}
