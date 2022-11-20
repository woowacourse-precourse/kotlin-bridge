package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    var bridgeSize: String? = ""
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String? {
        println("다리의 길이를 입력해주세요.")
        bridgeSize = Console.readLine()

        return bridgeSize
    }

    fun checkBridgeSizeException() {
        try {
            // 입력받은 숫자가 범위 밖인지, toInt를 통해 문자를 입력받았는지 판별 가능
            if (bridgeSize!!.toInt() < 3 || bridgeSize!!.toInt() > 20) {
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
