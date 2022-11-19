package bridge.consol

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {


    fun readBridgeSize(): Int {
        return try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR]숫자를 입력 해야 합니다.")
            readBridgeSize()
        }
    }

    fun readMoving(): String = Console.readLine()

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String = Console.readLine()
}
