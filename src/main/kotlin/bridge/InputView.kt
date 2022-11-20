package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun chkNum(str: String): Boolean {
        var temp: Char
        var result = false
        for (i in 0 until str.length) {
            temp = str.elementAt(i)
            if (temp.toInt() < 48 || temp.toInt() > 57) {
                result = true
            }
        }
        return result
    }

    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val bridgeSize = Console.readLine()
        inputBridgeException(bridgeSize.toInt())
        return bridgeSize.toInt()
    }

    fun inputBridgeException(bridgeLength: Int) {
        when {
            bridgeLength < 3 -> return throw IllegalArgumentException("[ERROR] 다리의 길이는 3보다 커야합니다.")
            bridgeLength > 20 -> return throw IllegalArgumentException("[ERROR] 다리의 길이는 20보다 작아야합니다.")
            chkNum(bridgeLength.toString()) -> return throw IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다.")
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val inputMoving = Console.readLine()
        inputMovingException(inputMoving)
        return inputMoving
    }

    fun inputMovingException(inputMoving: String) {
        when {
            inputMoving != "U" && inputMoving != "D" -> return throw IllegalArgumentException("[ERROR] 이동할 칸은 U와 D만 입력 가능합니다.")
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}