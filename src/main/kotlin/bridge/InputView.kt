package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private var inputValidator = false
    fun readBridgeSize(): Int {
        inputValidator = false
        var input = ""
        while (!inputValidator) {
            println("다리 길이를 입력해주세요.")
            input = Console.readLine()
            validateBridgeSizeInput(input)
        }
        return input.toInt()
    }

    private fun validateBridgeSizeInput(input: String) {
        try {
            InputValidator.checkOnlyNumber(input)
            InputValidator.checkInBridgeRange(input)
            inputValidator = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        inputValidator = false
        var input = ""
        while (!inputValidator) {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            input = Console.readLine()
            validateMovingInput(input)
        }
        return input
    }

    private fun validateMovingInput(input: String) {
        try {
            InputValidator.checkOnlyCharacter(input)
            InputValidator.checkUorD(input)
            inputValidator = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        inputValidator = false
        var input = ""
        while (!inputValidator) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            input = Console.readLine()
            validateGameCommandInput(input)
        }
        return input
    }

    private fun validateGameCommandInput(input: String) {
        try {
            InputValidator.checkOnlyCharacter(input)
            InputValidator.checkQorR(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
