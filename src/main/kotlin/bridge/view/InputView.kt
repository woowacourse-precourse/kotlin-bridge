package bridge.view

/** 사용자로부터 입력을 받는 역할을 한다. */

import bridge.Strings
import camp.nextstep.edu.missionutils.Console

class InputView {

    /** 다리의 길이를 입력받는다.*/
    fun readBridgeSize(): String {
        println(Strings.INPUT_BRIDGE_SIZE.phrases)
        val size = Console.readLine()

        return size
    }

    /** 게임 시작 문구 */
    fun startPhrases() {
        println(Strings.GAME_START.phrases + "\n")
    }

    /** 이동할 칸 입력 문구 */
    fun directionPhrases() {
        println(Strings.INPUT_BRIDGE_DIRECTION.phrases + "\n")
    }

    /**사용자가 이동할 칸을 입력받는다. */
    fun readMoving(): String {
        directionPhrases()
        val direction = Console.readLine()

        return direction
    }

    /** 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.*/
    fun readGameCommand(input : String): String? {
        if (input == "X"){
            println(Strings.INPUT_RESTART.phrases)
            val restart = Console.readLine()
            return restart
        }

        return null
    }
}
