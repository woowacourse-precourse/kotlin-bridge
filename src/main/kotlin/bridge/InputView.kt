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
        try {
            //   println("다리의 길이를 입력해주세요.")
            val bridgeSize = Console.readLine().toInt()

            if (bridgeSize < 3 || bridgeSize > 20) throw IllegalArgumentException()
            return bridgeSize
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 다리 길이는 3부터 20사이의 숫자여야합니다.")
        }
        return readBridgeSize()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        //    println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        try {
            val move = Console.readLine()
            if ((move != "U") && (move != "D")) throw IllegalArgumentException()
            return move
        } catch (e: IllegalArgumentException) {
            println("[ERROR] U와 D만 선택할 수 있습니다.")
        }
        return readMoving()

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
