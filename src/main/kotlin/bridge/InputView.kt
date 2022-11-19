package bridge

import camp.nextstep.edu.missionutils.Console
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val rule = Rule()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var bridgeSize = 0
        // todo 성공하면 반복문 나가게 수정
        var isMovable = false
        do {
            val input = Console.readLine()
            try {
                bridgeSize = rule.checkBridgeSize(input)
                isMovable = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (!isMovable)

        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var input = ""
        var isUpOrDown = false
        do {
            input = Console.readLine()
            try {
                rule.checkMoving(input)
                isUpOrDown = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        } while(!isUpOrDown)

        return input
    }


    // todo 위의 3개 로직 다 비슷하니까 하나로 통합하기 ( bridgeSize는 조금 다른 것 같기도 )
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        var input = ""
        var isCorrectCommand = false
        do {
            input = Console.readLine()
            try {
                rule.checkCommand(input)
                isCorrectCommand = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        } while(!isCorrectCommand)

        return input
    }
}
