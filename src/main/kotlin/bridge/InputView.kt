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
        println(BRIDGE_START)
        while (true) {
            println(BRIDGE_LENGTH)
            val readSize = numberCheck(Console.readLine())
            if (readSize !in 3..20)
                println(ERROR_LENGTH)
            if (readSize in 3..20)
                return readSize
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            println(BRIDGE_MOVE)
            val step = Console.readLine()
            if (!(step == "U" || step == "D"))
                println(ERROR_MOVE)
            if (step == "U" || step == "D")
                return step
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            println(BRIDGE_RESTART)
            val regame = Console.readLine()
            if (!(regame == "R" || regame == "Q"))
                println(ERROR_RESTART)
            if (regame == "R" || regame == "Q")
                return regame
        }
    }

    fun numberCheck(number: String): Int {
        return try {
            number.toInt()
        } catch (e: IllegalArgumentException) {
            0
        }
    }
}
