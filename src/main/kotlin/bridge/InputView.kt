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
        val errorCheck = ErrorCheck()
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        val bridgeLength = Console.readLine()
        val checkedLength = errorCheck.sentenceCheck(bridgeLength)
        return checkedLength
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
