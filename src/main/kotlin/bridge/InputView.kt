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
        println("다리 길이를 입력해주세요.")
        val input = Console.readLine()
        InputValidator.checkOnlyNumber(input)
        InputValidator.checkInBridgeRange(input)
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val input = Console.readLine()
        InputValidator.checkOnlyCharacter(input)
        InputValidator.checkUorD(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val input= Console.readLine()
        InputValidator.checkOnlyCharacter(input)
        InputValidator.checkQorR(input)
        return input
    }
}
