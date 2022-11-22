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
        var userInputBridgeSize = getUserInputBridgeSize()
        while(!Regex(userInputBridgeSize).checkBridgeLengthRegexes()) {
            userInputBridgeSize = getUserInputBridgeSize()
        }
        return userInputBridgeSize.toInt()
    }

    private fun getUserInputBridgeSize() : String {
        PrintForm().printPleaseInputBridgeLength()
        return Console.readLine()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var userInputMovement = getUserInputMovement()
        while(!Regex(userInputMovement).checkUserMovementRegexes()) {
            userInputMovement = getUserInputBridgeSize()
        }
        return userInputMovement
    }

    private fun getUserInputMovement() : String {
        PrintForm().printUserMovementForm()
        return Console.readLine()
    }



    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        var userInputRetry = getUserRetry()
        while(!Regex(userInputRetry).checkUserRetryRegexes()) {
            userInputRetry = getUserRetry()
        }
        return userInputRetry
    }

    private fun getUserRetry() : String {
        PrintForm().printWannaRetry()
        return Console.readLine()
    }
}
