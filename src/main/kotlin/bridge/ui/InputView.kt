package bridge.ui

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
        val userInputText = Console.readLine()
        requireNotNull(userInputText.toIntOrNull()) {
            print("[ERROR] 숫자를 입력해주세요")
            return readBridgeSize()
        }
        require(userInputText.toInt() in 3..20) {
            println("[ERROR] 3~20사이의 숫자만 입력해주세요")
            return readBridgeSize()
        }
        return userInputText.toInt()
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val userInputText = Console.readLine()
        require(userInputText == "U" || userInputText == "D") {
            println("[ERROR] U 또는 D중 하나의 문자만 입력해주세요")
            return readMoving()
        }
        return userInputText
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val userInputText = Console.readLine()
        require(userInputText == "R" || userInputText == "Q") {
            println("[ERROR] R 또는 Q중 하나의 문자만 입력해주세요")
            return readGameCommand()
        }
        return userInputText
    }
}
