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
        var bridgeSize: Int = 0
        // todo 성공하면 반복문 나가게 수정
        var isMovable = false
        do {
            val input = Console.readLine()
            try {
                bridgeSize = rule.checkBridgeSize(input)
                isMovable = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
                isMovable = false
            }
        } while (!isMovable)

        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val input = Console.readLine()
        // rule을 통해 옳바른 값을 받았는지 체크
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input = Console.readLine()
        // rule을 통해 옳바른 값을 받았는지 체크
        return input
    }
}
