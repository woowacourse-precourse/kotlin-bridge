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
        val input = Console.readLine()
        InputValidator.checkOnlyNumber(input)
        InputValidator.checkInBridgeRange(input)
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val input = Console.readLine()
        InputValidator.checkOnlyCharacter(input)
        InputValidator.checkUorD(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input= Console.readLine()
        InputValidator.checkOnlyCharacter(input)
        InputValidator.checkQorR(input)
        return input
    }
}
