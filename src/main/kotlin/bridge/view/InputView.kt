package bridge.view

import bridge.domain.Validator
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try {
            println("다리의 길이를 입력해주세요.")
            return Validator.isValidBridgeSize(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try {
            println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
            return Validator.isValidMoving(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try {
            println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            return Validator.isValidRetryCommand(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readGameCommand()
        }
    }

    fun readStartGame() {
        println("다리 건너기 게임을 시작합니다.\n")
    }
}
