package bridge.view

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

import bridge.Strings
import camp.nextstep.edu.missionutils.Console

class InputView {

    /**다리의 길이를 입력받는다.*/
    fun readBridgeSize(): Int {
        startPhrases()
        val size = Console.readLine().toInt()

        return size
    }

    fun startPhrases(){
        println(Strings.GAME_START.phrases+"\n")
        println(Strings.INPUT_BRIDGE_SIZE.phrases)
    }

    /**사용자가 이동할 칸을 입력받는다.*/
    fun readMoving(): String {
        return ""
    }

    /**사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.*/
    fun readGameCommand(): String {
        return ""
    }
}
