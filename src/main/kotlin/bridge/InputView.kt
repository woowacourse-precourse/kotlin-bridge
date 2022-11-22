package bridge

import org.mockito.internal.matchers.Null

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    val error = Error()

    /**
     * 다리의 길이를 입력받는다.
     */

    fun readBridgeSize(): Int {
        var bridgeSize = ""
        var flag = false
        while (flag == false){
            try {
                bridgeSize = readLine()!!.toString()
                flag = error.checkBridgeSize(bridgeSize)
            } catch (e: IllegalArgumentException ){
                println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            }
        }
        return bridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var movingDirection = ""
        var flag = false
        while ( flag == false ) {
            movingDirection = readLine()!!.toString()
            flag = error.checkDirection(movingDirection)
        }
        return movingDirection
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        var gameCommand = ""
        var flag = false
        while (flag == false) {
            gameCommand = readLine()!!.toString()
            flag = error.checkGameCommand(gameCommand)
        }
        return gameCommand
    }
}
