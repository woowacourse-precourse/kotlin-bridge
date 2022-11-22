package bridge

import kotlin.system.exitProcess

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.")
        while(true) {
            try {
                val input = readLine()
                checkBridgeSize(input)
                return input!!.toInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            }
        }
    }

    private fun checkBridgeSize(input: String?) {
        if(input == null) {
            exitProcess(0)
        }
        var result = 0
        try {
            result = input.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
        if(result < 3 || result > 20) {
            throw IllegalArgumentException()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")

        while(true) {
            try {
                val input = readLine()
                checkMoving(input)
                return input!!
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 이동할 칸은 U 또는 D로 입력해야 합니다.")
            }
        }
    }

    private fun checkMoving(input: String?) {
        if(input == null) {
            exitProcess(0)
        }
        if(input != "U" && input != "D") {
            throw IllegalArgumentException()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")

        while(true) {
            try {
                val input = readLine()
                checkCommand(input)
                return input!!
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 재시도 여부는 R 또는 Q로 입력해야 합니다.")
            }
        }
    }

    private fun checkCommand(input: String?) {
        if(input == null) {
            exitProcess(0)
        }
        if(input != "R" && input != "Q") {
            throw IllegalArgumentException()
        }
    }
}