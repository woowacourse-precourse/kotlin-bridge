package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val input = Console.readLine()
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
        }
        if (input.toInt() !in 3..20) {
            throw IllegalArgumentException("[ERROR] 3이상 20이하가 아닙니다.")
        }
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val input = Console.readLine()
        if (!(input == "U" || input == "D")) {
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        }
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
