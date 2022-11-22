package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    companion object {
        var bridgeSize: String = ""
        var chooseUpOrDown: String = ""
        var chooseRestartOrQuit: String = ""
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
        println("다리의 길이를 입력해주세요.")
        bridgeSize = Console.readLine()

        return bridgeSize
    }

    fun checkBridgeSizeException(size: String) {
        try {
            if (!checkDigit(size)) throw IllegalArgumentException()
            else if (size.toInt() < 3 || size.toInt() > 20) throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            readBridgeSize()
        }
    }

    fun checkDigit(input: String): Boolean {
        var digitFlag = true
        for (s in input) {
            if (!s.isDigit()) digitFlag = false
        }
        return digitFlag
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        chooseUpOrDown = Console.readLine()

        return chooseUpOrDown
    }

    fun checkMovingInputException(chooseUpOrDown: String) {
        try {
            if (chooseUpOrDown != "U" && chooseUpOrDown != "D") {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] U(위 칸)나 D(아래 칸) 중 하나만 입력할 수 있습니다.")
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        chooseRestartOrQuit = Console.readLine()

        return chooseRestartOrQuit
    }

    fun checkGameCommandInputException(chooseRestartOrQuit: String) {
        try {
            if (chooseRestartOrQuit != "R" && chooseRestartOrQuit != "Q") {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] R(재시작)과 Q(종료) 중 하나만 입력할 수 있습니다.")
            readGameCommand()
        }
    }
}
