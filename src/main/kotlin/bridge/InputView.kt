package bridge

import camp.nextstep.edu.missionutils.Console
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
private val validNum = "^[3-9]$|^[1][0-9]$|^[2][0]$".toRegex()
class InputView {

    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        var user = Console.readLine()
        if(!user.matches(validNum)){
            throw IllegalArgumentException("[ERROR] 입력 형식이 잘못 되었습니다.")
        }

        return user.toInt()
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
