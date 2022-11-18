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
        val bridgeSize = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            print("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다.")
            Console.readLine().toInt()
        }
        checkBridgeSize(bridgeSize)
        return bridgeSize
    }

    private fun checkBridgeSize(bridgeSize: Int) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다.")
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val whereToMove = Console.readLine()

        if (whereToMove != "U" && whereToMove != "D") {
            throw IllegalArgumentException("[ERROR] U나 D를 입력해주세요.")
        }

        return whereToMove
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("\n게임을 다시 시작할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val retryOrQuit = Console.readLine()

        if (retryOrQuit != "R" && retryOrQuit != "Q") {
            throw IllegalArgumentException("[ERROR] R이나 Q를 입력해주세요.")
        }
        return retryOrQuit
    }
}
