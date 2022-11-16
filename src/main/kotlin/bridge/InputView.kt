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
        return try {
            getBridgeSize()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return try {
            getMoving()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun getBridgeSize(): Int {
        val size: Int
        try {
            size = Console.readLine().toInt()
            if (size < 3 || size > 20) throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다.")
        }
        return size
    }

    private fun getMoving(): String {
        val moving: String = Console.readLine().trim()
        if (moving != "U" && moving != "D") throw IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.")
        return moving
    }
}
