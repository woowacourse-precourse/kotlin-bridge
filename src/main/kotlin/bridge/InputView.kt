package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    var bridgeSize: String? = ""
    var chooseUpOrDown: String = ""

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
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        chooseUpOrDown = Console.readLine()

        return chooseUpOrDown
    }

    fun checkMovingInputException() {
        try {
            if (chooseUpOrDown != "U" && chooseUpOrDown != "D") {
                chooseUpOrDown.toInt()
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] U(위 칸)나 D(아래 칸)만 입력할 수 있습니다.")
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
